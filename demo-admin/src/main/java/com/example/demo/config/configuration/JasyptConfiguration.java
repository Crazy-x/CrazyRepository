package com.example.demo.config.configuration;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 密码加密配置类
 */
@Configuration
public class JasyptConfiguration {

    // @Bean("jasyptStringEncryptor")
    // public StringEncryptor stringEncryptor() {
    // PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
    // SimpleStringPBEConfig config = new SimpleStringPBEConfig();
    // config.setPassword("password");
    // config.setAlgorithm("PBEWithMD5AndDES");
    // config.setKeyObtentionIterations("1000");
    // config.setPoolSize("1");
    // config.setProviderName("SunJCE");
    // config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
    // config.setStringOutputType("base64");
    // encryptor.setConfig(config);
    // return encryptor;
    // }

    @Bean
    public BasicPasswordEncryptor basicPasswordEncryptor() {
        return new BasicPasswordEncryptor();
    }
}
