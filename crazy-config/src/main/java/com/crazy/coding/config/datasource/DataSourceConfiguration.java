package com.crazy.coding.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "datasource.master")
    public DataSource masterDataSource() {
        return new DruidDataSource();
    }

    @Bean
    @Primary
    public DynamicDataSource dataSource() {
        DynamicDataSource datasource = new DynamicDataSource();

        Map<Object, Object> targetDataSources = new HashMap<Object, Object>(2);
        targetDataSources.put("master", masterDataSource());

        datasource.setTargetDataSources(targetDataSources);
        datasource.setDefaultTargetDataSource(targetDataSources.get("master"));

        return datasource;
    }
}
