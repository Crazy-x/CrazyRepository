package com.crazy.coding.config.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;
import java.util.concurrent.Executors;

@Configuration
@EnableJms
public class JmsConfiguration {

    private static final Logger log = LoggerFactory.getLogger(JmsConfiguration.class);

    /**
     * 点对点消息队列模式
     */
    @Bean
    public Queue queue() {
        log.debug("Queue starting!");
        return new ActiveMQQueue("simple.queue");
    }

    /**
     * 发布/订阅主题模式
     */
    @Bean
    public Topic topic() {
        log.debug("Topic starting!");
        return new ActiveMQTopic("simple.topic");
    }

    /**
     * topic模式的ListenerContainer
     */
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);
        bean.setTaskExecutor(Executors.newFixedThreadPool(6));
        bean.setConcurrency("6");
        bean.setConnectionFactory(activeMQConnectionFactory);
//        使用消息转换器
//        bean.setMessageConverter(jacksonJmsMessageConverter());
        return bean;
    }

    /**
     * queue模式的ListenerContainer
     */
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerQueue(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(false);
        bean.setTaskExecutor(Executors.newFixedThreadPool(6));
        bean.setConcurrency("6");
        bean.setConnectionFactory(activeMQConnectionFactory);
//        使用消息转换器
//        bean.setMessageConverter(jacksonJmsMessageConverter());
        return bean;
    }

    /**
     * 消息转换器
     */
    @Bean
    public MappingJackson2MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

}
