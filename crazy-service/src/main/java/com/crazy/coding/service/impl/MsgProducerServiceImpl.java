package com.crazy.coding.service.impl;

import com.crazy.coding.service.MsgProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * 消息生产者
 */
@Service
public class MsgProducerServiceImpl implements MsgProducerService {

    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    @Override
    public void sendQueueMessage(Object message) {
        jmsTemplate.convertAndSend(queue, message);
    }

    @Override
    public void sendTopicMessage(Object message) {
        jmsTemplate.convertAndSend(topic, message);
    }

}
