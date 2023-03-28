package com.example.demo.jedis.controller;

import com.example.demo.jedis.service.RedisService;
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
@RequestMapping("/jedis")
public class jedisController {

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

    @GetMapping("/getAllKeys")
    public ResponseEntity getAllKeys() {
        return ResponseEntity.ok(redisService.getAllKeys());
    }
}
