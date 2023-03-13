package com.example.demo.scheduler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author maxiao
 */
@Slf4j
@RestController
@RequestMapping("scheduler")
public class SchedulerController {

    @Resource
    TestSchedulerConfig testSchedulerConfig;


    @GetMapping("/set")
    public void setCron(@RequestParam("cron") String cron) {
        testSchedulerConfig.setTestCron(cron);
    }

}
