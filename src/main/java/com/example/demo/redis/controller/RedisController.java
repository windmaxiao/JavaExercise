package com.example.demo.redis.controller;

import com.example.demo.redis.service.RedisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author maxiao
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Resource
    RedisService redisService;

    @GetMapping("/getData")
    public ResponseEntity getData(@RequestParam("key") String key) {
        return ResponseEntity.ok(redisService.get(key, String.class));
    }

    @GetMapping("/setData")
    public void setData(@RequestParam("key") String key, @RequestParam("value") String value) {
        redisService.set(key, value);
    }
}
