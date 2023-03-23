package com.example.demo.scheduler.schedulers;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 动态定时任务测试类
 * @author maxiao
 */
@Component
@Slf4j
@Getter
@Setter
public class TestSchedulerConfig implements SchedulingConfigurer {

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    @Value("${scheduler.testCron}")
    private String testCron;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        // 使用cron表达式可以动态地设置循环间隔
        taskRegistrar.addTriggerTask(() -> {
            log.info(">>>>>>动态定时任务开始时间： {}", LocalDateTime.now().format(DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS)));
            try {
                // 定时任务具体业务逻辑，模拟业务逻辑处理
                log.info("动态定时任务具体业务逻辑，模拟业务逻辑处理......");
                System.out.println("动态定时任务执行啦！！！！！！！");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error("动态定时任务处理失败", e);
                Thread.currentThread().interrupt();
            }
            log.info(">>>>>>动态定时任务结束时间： {}", LocalDateTime.now().format(DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS)));
        }, triggerContext -> {
            // 使用CronTrigger触发器，可动态修改cron表达式来操作循环规则
            CronTrigger cronTrigger = new CronTrigger(testCron);
            return cronTrigger.nextExecutionTime(triggerContext);
        });
    }
}
