package com.crazy.coding.config.configuration;

import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import io.github.jhipster.config.JHipsterProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.MimeMappings;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;


@Configuration
public class WebConfigurer implements ServletContextInitializer, EmbeddedServletContainerCustomizer {

    private final Logger log = LoggerFactory.getLogger(WebConfigurer.class);

    private final Environment env;

    private final JHipsterProperties jHipsterProperties;

    /**
     * 使用 final 关键字在构造函数初始化类，可以防止重复初始化，从而影响到类属性调用
     * 其实用@esource注解注入也一样
     */
    public WebConfigurer(Environment env, JHipsterProperties jHipsterProperties) {
        this.env = env;
        this.jHipsterProperties = jHipsterProperties;
    }

    /**
     * servlet启动时打印一下环境配置信息，其实可以不用实现这个接口
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        if (env.getActiveProfiles().length != 0) {
            log.info("Web application configuration, using profiles: {}", (Object[]) env.getActiveProfiles());
        }
        log.info("Web application fully configured");
    }

    /**
     * <p>
     * 定制Servlet引擎:Mime类型，对html静态页面和json格式数据设置编码；
     * 对应的是web.xml里面的<mime-mapping> 标签。
     * </p>.
     */
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        MimeMappings mappings = new MimeMappings(MimeMappings.DEFAULT);

        mappings.add("html", "text/html;charset=utf-8");
        mappings.add("json", "text/html;charset=utf-8");

        container.setMimeMappings(mappings);
    }

    /**
     * CORS解决跨域问题的过滤器
     */
    @Bean
    public CorsFilter corsFilter() {

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration config = jHipsterProperties.getCors();

        if (CollectionUtils.isNotEmpty(config.getAllowedOrigins())) {

            log.debug("Registering CORS filter");

            source.registerCorsConfiguration("/api/**", config); // 跨域访问所有以/api/开头的地址
            source.registerCorsConfiguration("/v2/api-docs", config); // 跨域访问api文档信息
        }

        return new CorsFilter(source);
    }
}
