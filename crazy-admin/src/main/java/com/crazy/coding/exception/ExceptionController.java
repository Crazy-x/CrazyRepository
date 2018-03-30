package com.crazy.coding.exception;

import com.crazy.coding.config.exception.ExceptionInfoBuilder;
import com.crazy.coding.entity.common.ExceptionInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("${server.error.path:/error}")
public class ExceptionController implements ErrorController {

    @Autowired
    private ExceptionInfoBuilder exceptionInfoBuilder;//异常信息构建工具

    private final static String NOT_FOUND_VIEW = "error/404";//错误信息页

    private final static String DEFAULT_EXCEPTION_VIEW = "error/exception";//默认的异常页面

    /**
     * 情况1：若预期返回类型为text/html,则返回异常信息页(View).
     */
    @RequestMapping(produces = {MediaType.TEXT_HTML_VALUE})
    public ModelAndView exceptionHtml(HttpServletRequest request) {
        ExceptionInfo info = exceptionInfoBuilder.getExceptionInfo(request);
        //如果找不到页面
        if (StringUtils.equalsIgnoreCase(info.getReasonPhrase(), HttpStatus.NOT_FOUND.getReasonPhrase())) {
            return new ModelAndView(NOT_FOUND_VIEW);
        }
        return new ModelAndView(DEFAULT_EXCEPTION_VIEW, "exceptionInfo", info);
    }

    /**
     * 情况2：其它预期类型 则返回详细的异常信息(JSON).
     */
    @RequestMapping
    public ExceptionInfo exception(HttpServletRequest request) {
        return exceptionInfoBuilder.getExceptionInfo(request);
    }

    @Override
    public String getErrorPath() {//获取映射路径
        return exceptionInfoBuilder.getErrorProperties().getPath();
    }
}
