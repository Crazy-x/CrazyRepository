package com.crazy.coding.config.exception;

import com.crazy.coding.entity.common.ExceptionInfo;
import com.sun.istack.internal.Nullable;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class ExceptionInfoBuilder implements HandlerExceptionResolver, Ordered {

    /**
     * 错误KEY
     */
    private final static String ERROR_NAME = "error";

    /**
     * 错误配置(ErrorConfiguration)
     */
    private ErrorProperties errorProperties;

    public ErrorProperties getErrorProperties() {
        return errorProperties;
    }

    public void setErrorProperties(ErrorProperties errorProperties) {
        this.errorProperties = errorProperties;
    }

    /**
     * 错误构造器 (Constructor) 传递配置属性：server.xx -> server.error.xx
     */
    public ExceptionInfoBuilder(ServerProperties serverProperties) {
        this.errorProperties = serverProperties.getError();
    }

    /**
     * 构建错误信息.(ExceptionInfo)
     */
    public ExceptionInfo getExceptionInfo(HttpServletRequest request) {

        return getExceptionInfo(request, getException(request));
    }

    /**
     * 构建错误信息.(ExceptionInfo)
     */
    public ExceptionInfo getExceptionInfo(HttpServletRequest request, Throwable error) {
        ExceptionInfo exceptionInfo = new ExceptionInfo();
        exceptionInfo.setTime(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        exceptionInfo.setUrl(request.getRequestURL().toString());
        exceptionInfo.setError(error.toString());
        exceptionInfo.setStatusCode(getHttpStatus(request).value());
        exceptionInfo.setReasonPhrase(getHttpStatus(request).getReasonPhrase());
        exceptionInfo.setStackTrace(getStackTraceInfo(error, isIncludeStackTrace(request)));
        return exceptionInfo;
    }

    /**
     * 获取错误.(Error/Exception)
     */
    public Throwable getException(HttpServletRequest request) {
        //根据HandlerExceptionResolver接口方法来获取错误.
        Throwable error = (Throwable) request.getAttribute(ERROR_NAME);
        //根据Request对象获取错误.
        if (error == null) {
            error = (Throwable) request.getAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE);
        }
        //当获取错误非空,取出RootCause.
        if (error != null) {
            while (error instanceof ServletException && error.getCause() != null) {
                error = error.getCause();
            }
        }//当获取错误为null,此时我们设置错误信息即可.
        else {
            String message = (String) request.getAttribute(WebUtils.ERROR_MESSAGE_ATTRIBUTE);
            if (StringUtils.isEmpty(message)) {
                HttpStatus status = getHttpStatus(request);
                message = "Unknown Exception But " + status.value() + " " + status.getReasonPhrase();
            }
            error = new Exception(message);
        }
        return error;
    }

    /**
     * 获取通信状态(HttpStatus)
     */
    public HttpStatus getHttpStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute(WebUtils.ERROR_STATUS_CODE_ATTRIBUTE);
        try {
            return statusCode != null ? HttpStatus.valueOf(statusCode) : HttpStatus.INTERNAL_SERVER_ERROR;
        } catch (Exception ex) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    /**
     * 获取堆栈轨迹(StackTrace)
     */
    public String getStackTraceInfo(Throwable error, boolean flag) {
        if (!flag) {
            return "omitted";
        }
        StringWriter stackTrace = new StringWriter();
        error.printStackTrace(new PrintWriter(stackTrace));
        stackTrace.flush();
        return stackTrace.toString();
    }

    /**
     * 判断是否包含堆栈轨迹.(isIncludeStackTrace)
     */
    public boolean isIncludeStackTrace(HttpServletRequest request) {

        //读取错误配置(server.error.include-stacktrace=NEVER)
        ErrorProperties.IncludeStacktrace includeStacktrace = errorProperties.getIncludeStacktrace();

        //情况1：若IncludeStacktrace为ALWAYS
        if (includeStacktrace == ErrorProperties.IncludeStacktrace.ALWAYS) {
            return true;
        }
        //情况2：若请求参数含有trace
        if (includeStacktrace == ErrorProperties.IncludeStacktrace.ON_TRACE_PARAM) {
            String parameter = request.getParameter("trace");
            return parameter != null && !"false".equals(parameter.toLowerCase());
        }
        //情况3：其它情况
        return false;
    }

    /**
     * 保存错误/异常.
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, @Nullable Object handler, Exception ex) {
        request.setAttribute(ERROR_NAME, ex);
        return null;
    }

    /**
     * 提供优先级 或用于排序
     */
    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
