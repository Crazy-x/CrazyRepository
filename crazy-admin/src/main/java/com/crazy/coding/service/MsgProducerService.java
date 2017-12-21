package com.crazy.coding.service;

public interface MsgProducerService {

    void sendQueueMessage(Object message);

    void sendTopicMessage(Object message);
}
