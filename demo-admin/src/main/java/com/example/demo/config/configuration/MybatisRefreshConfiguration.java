package com.example.demo.config.configuration;

import com.baomidou.mybatisplus.spring.MybatisMapperRefresh;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * mapper.xml热加载，只在dev环境中配置
 */
@Profile("dev")
@Configuration
public class MybatisRefreshConfiguration {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @SuppressWarnings("deprecation")
    @Bean
    public MybatisMapperRefresh mybatisMapperRefresh() throws Exception {
        return new MybatisMapperRefresh(
                new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"),
                sqlSessionFactory,
                3,
                20,
                true);
    }
}
