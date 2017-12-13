package com.crazy.coding.service.impl;

import com.crazy.coding.service.ScheduledService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class ScheduledServiceImpl implements ScheduledService {

    private static Logger log = LoggerFactory.getLogger(ScheduledServiceImpl.class);

    @Override
    @Scheduled(cron = "0 * * * * ?")
    public void task() {
        log.info("task is ok !");
    }


    @Override
    @Async("taskExecutor")
    @Scheduled(cron = "0 * * * * ?")
    public void asyncTask1() {
        log.info("asyncTask1 is ok !");
    }

    @Override
    @Async
    @Scheduled(cron = "0 * * * * ?")
    public void asyncTask2() {
        log.info("asyncTask2 is ok !");
    }
}
