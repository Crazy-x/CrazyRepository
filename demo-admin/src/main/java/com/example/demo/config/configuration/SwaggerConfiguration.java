package com.example.demo.config.configuration;

import io.github.jhipster.config.JHipsterProperties;
import io.github.jhipster.config.JHipsterProperties.Swagger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Swagger UI 配置类，可以查看API信息了
 *
 * 查看网址：http://127.0.0.1:8000/swagger-ui.html
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    private static final Logger log = LoggerFactory.getLogger(SwaggerConfiguration.class);

    /**
     * Swagger Springfox configuration.
     *
     * @param properties the properties of the application
     * @return the Swagger Springfox configuration
     */
    @Bean
    public Docket swaggerSpringfoxDocket(JHipsterProperties properties) {
        log.debug("Starting Swagger");
        StopWatch watch = new StopWatch();
        Swagger swagger = properties.getSwagger();

        watch.start();
        Contact contact = new Contact(
                swagger.getContactName(),
                swagger.getContactUrl(),
                swagger.getContactEmail());

        ApiInfo apiInfo = new ApiInfo(
                swagger.getTitle(),
                swagger.getDescription(),
                swagger.getVersion(),
                swagger.getTermsOfServiceUrl(),
                contact,
                swagger.getLicense(),
                swagger.getLicenseUrl());

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .forCodeGeneration(true)
                .genericModelSubstitutes(ResponseEntity.class)
                .select()
                .paths(regex(swagger.getDefaultIncludePattern()))
                .build();
        watch.stop();

        log.debug("Started Swagger in {} ms", watch.getTotalTimeMillis());
        return docket;
    }
}
