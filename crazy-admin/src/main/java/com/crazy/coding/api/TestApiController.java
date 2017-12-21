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
@Api(value = "Test API", description = " API")
@RestController
@RequestMapping("/api/test")
public class TestApiController {

    @Resource
    private TestService testService;

    @Resource
    private MsgProducerService producerService;

    @GetMapping("/send")
    @ApiOperation(value = "ActiveMQ Send Message Test", notes = "ActiveMQ Send Message Test")
    public String send() {

        producerService.sendQueueMessage("This is queue message!");
        producerService.sendTopicMessage("This is topic message!");

        return testService.getMessage();
    }

}
