package com.example.demo.scheduler.schedulers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务类 测试多个定时任务造成阻塞现象
 * @author maxiao
 */
@Slf4j
@Component
public class SchedulerBlock {

    /**
     * 定时任务1，每15秒执行一次，会执行10秒（造成10秒阻塞）
     * @throws InterruptedException InterruptedException
     */
    @Async(value = "asyncServiceExecutor")
    @Scheduled(cron = "0/15 * * * * ?")
    public void taskCron1() throws InterruptedException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        log.info("taskCron1 - 执行定时任务【0/15 * * * * ?】，时间： " + dateFormat.format(new Date()));
        log.info("taskCron1 - 线程名称 " + Thread.currentThread().getName());
        //模拟延时
        Thread.sleep(10*1000);
    }



    /**
     * 定时任务2，每3秒执行一次
     */
    @Async(value = "asyncServiceExecutor")
    @Scheduled(cron = "0/3 * * * * ?")
    public void taskCron2(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        log.info("taskCron2 - 执行定时任务【0/3 * * * * ? 】，时间： " + dateFormat.format(new Date()));
        log.info("taskCron2 - 线程名称 " + Thread.currentThread().getName());
    }

}
