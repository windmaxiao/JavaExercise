package com.example.demo.redis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;

public class RedisBound {

    @Autowired
    StringRedisTemplate stringRedisTemplate;


    public void testBound(String key) {

        BoundValueOperations<String, String> boundValueOperations = stringRedisTemplate.boundValueOps(key);
        String s = boundValueOperations.get();
        boundValueOperations.set("xxx");


        BoundListOperations<String, String> list = stringRedisTemplate.boundListOps("list");
        BoundSetOperations<String, String> set = stringRedisTemplate.boundSetOps("set");
        BoundZSetOperations<String, String> zset = stringRedisTemplate.boundZSetOps("zset");
        BoundHashOperations<String, Object, Object> hash = stringRedisTemplate.boundHashOps("hash");



    }
}
