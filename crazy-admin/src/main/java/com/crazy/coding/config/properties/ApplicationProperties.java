package com.crazy.coding.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 从*.yml配置文件中读取application下对应的属性，然后注入为bean
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = true)
public class ApplicationProperties {

    private String basePackage;


    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }
}
