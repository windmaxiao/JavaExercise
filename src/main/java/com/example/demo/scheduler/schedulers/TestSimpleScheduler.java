package com.example.demo.scheduler.schedulers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 静态定时任务执行
 * @author maxiao
 */
@Component
@Slf4j
public class TestSimpleScheduler {

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    @Scheduled(cron = "${scheduler.testCron}")
    public void testScheduler() {
        log.info("定时任务开始时间： {}", LocalDateTime.now().format(DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS)));
        try {
            // 定时任务具体业务逻辑，模拟业务逻辑处理
            log.info("定时任务具体业务逻辑，模拟业务逻辑处理......");
            System.out.println("静态定时任务执行啦！！！！！！！");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("定时任务执行失败", e);
            Thread.currentThread().interrupt();
        }
        log.info("定时任务结束时间： {}", LocalDateTime.now().format(DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS)));
    }

}
