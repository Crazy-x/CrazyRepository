package com.crazy.coding.config.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.HttpMessageConverter;

import javax.annotation.Resource;

/**
 * <p>
 * spring boot 自带的是转换工具是jackson,也就是使用注解@ResponseBody的默认的效果；
 * 这里是把默认的变成fastjson，因为更快！！
 * 已经在WebConfigurer处理过中文乱码的问题了，所以这里不用。
 * </p>
 */
@Configuration
@ConditionalOnClass({JSON.class})
public class FastJsonConfiguration {

    @Resource
    private Environment env;

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {

        //定义一个转换消息的对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

        FastJsonConfig fastJsonConfig = new FastJsonConfig();

        // 检测有没有启动dev环境
        if (env.acceptsProfiles("dev")) {
            fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        }

        // 过滤敏感属性
        SimplePropertyFilter filter = new SimplePropertyFilter("password");
        fastJsonConfig.setSerializeFilters(filter);

        //在转换器中添加配置信息
        fastConverter.setFastJsonConfig(fastJsonConfig);

        HttpMessageConverter<?> converter = fastConverter;

        return new HttpMessageConverters(converter);
    }
}
