package com.crazy.coding.api;

import com.crazy.coding.service.MsgProducerService;
import com.crazy.coding.service.TestService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 测试控制器
 */
@RestController
@RequestMapping("/api/test")
public class TestApiController {

    @Resource
    private TestService testService;

    @Resource
    private MsgProducerService producerService;

    @GetMapping("/send")
    public String send() {

        producerService.sendQueueMessage("This is queue message!");
        producerService.sendTopicMessage("This is topic message!");

        return testService.getMessage();
    }

}
