package com.crazy.test;

import com.crazy.coding.Application;
import com.crazy.coding.service.MsgProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 消息消费者测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MsgConsumerTest {

    @Resource
    private MsgProducerService producerService;

    private static Logger log = LoggerFactory.getLogger(MsgConsumerTest.class);

    @Test
    public void start() {
//        log.debug("Message test start!");
//        producerService.sendQueueMessage("This is queue message!");
//        log.debug("Send queue message ok!");
//        producerService.sendTopicMessage("This is topic message!");
//        log.debug("Send topic message ok!");
    }

//    @JmsListener(destination = "simple.queue", containerFactory = "jmsListenerContainerQueue")
//    public void queue(Object message) {
//        log.debug("Queue：" + message);
//    }
//
//    @JmsListener(destination = "simple.topic", containerFactory = "jmsListenerContainerTopic")
//    public void topic(Object message) {
//        log.debug("Topic：" + message);
//    }
}
