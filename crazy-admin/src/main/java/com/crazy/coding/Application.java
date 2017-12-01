package com.crazy.coding;

import com.crazy.coding.config.properties.ApplicationProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

@ComponentScan
@MapperScan(basePackages = {"com.crazy.coding.mapper"}, annotationClass = Repository.class)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@EnableConfigurationProperties({ApplicationProperties.class})

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
