package com.example.demo.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

/**
 * @author maxiao
 */
@Service
public class RedisTemplateService {

    @Autowired
    private RedisTemplate redisTemplate;


    /*===========================================String 数据类型操作===================================================*/
    /**
     * String 类型的 GET 命令
     * @param key key
     * @return
     */
    public String getStringValue(String key) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        return null;
    }

    /**
     * String 的 SET 命令
     * @param key
     * @param value
     */
    public void setStringValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }



    /*===========================================String 数据类型操作===================================================*/

}
