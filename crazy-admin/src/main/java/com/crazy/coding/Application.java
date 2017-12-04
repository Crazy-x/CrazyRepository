package com.crazy.coding;

import com.crazy.coding.config.properties.ApplicationProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;


//组件扫描，如service、controller，repository，默认扫描当前类所在的包，也就是com.crazy.coding！
@ComponentScan
//mapper文件扫描：**.mapper包下所有注解为Repository的类，可以添加多个包，后面一句可以不写。
@MapperScan(basePackages = {"com.crazy.coding.mapper"}, annotationClass = Repository.class)
//开启自动配置：自动把所有Configuration文件注入为bean，排除springboot自带的数据源配置类
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
//开启配置属性：所有Properties文件都需在这里注明
@EnableConfigurationProperties({ApplicationProperties.class})

// @SpringBootApplication =  @Configuration + @EnableAutoConfiguration + @ComponentScan。
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
