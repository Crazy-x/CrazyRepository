package com.crazy.coding.service.impl;

import com.crazy.coding.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TestServiceImpl implements TestService {

    private static final Logger log = LoggerFactory.getLogger(TestServiceImpl.class);

    @Override
    public String getMessage() {
        return "Ojbk!";
    }

    @Override
    @JmsListener(destination = "simple.queue", containerFactory = "jmsListenerContainerQueue")
    public void queue(Object message) {
        log.debug("Queue：" + message);
    }

    @Override
    @JmsListener(destination = "simple.topic", containerFactory = "jmsListenerContainerTopic")
    public void topic(Object message) {
        log.debug("Topic：" + message);
    }

}
