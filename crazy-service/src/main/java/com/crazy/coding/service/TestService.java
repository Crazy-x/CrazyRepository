package com.crazy.coding.service;

public interface TestService {

    String getMessage();

    void queue(Object message);

    void topic(Object message);
}
