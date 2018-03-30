package com.crazy.coding.api;

import com.crazy.coding.service.MsgProducerService;
import com.crazy.coding.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
