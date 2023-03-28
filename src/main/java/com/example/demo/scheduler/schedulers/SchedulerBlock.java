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
//    @Async(value = "asyncServiceExecutor")
//    @Scheduled(cron = "0/15 * * * * ?")
//    public void taskCron() throws InterruptedException {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//        log.info("taskCron - 执行定时任务【从数据库中移除已删除超30天的数据】，时间： " + dateFormat.format(new Date()));
//        //模拟延时
//        Thread.sleep(10*1000);
//    }

    /**
     * 定时任务2，每3秒执行一次
     */
//    @Async(value = "asyncServiceExecutor")
//    @Scheduled(cron = "0/3 * * * * ?")
//    public void taskFixedRate(){
//        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//        log.info("taskFixedRate - 执行定时任务【注销已超1天未支付的订单】，时间： " + dateFormat.format(new Date()));
//    }

}
