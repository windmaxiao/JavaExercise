package com.example.demo.jedis.service;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

/**
 * @author maxiao
 */
@Service
public class RedisService {

    @Autowired
    private JedisPool jedisPool;

    public <T> T get(String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String str = jedis.get(key);
            return stringToBean(str,clazz);
        } finally {
            close(jedis);
        }
    }

    public <T> void set(String key, T value) {
        Jedis jedis = null;
        try {
            String str = value.toString();
            if (str == null || str.length() == 0) {
                return;
            }
            jedis = jedisPool.getResource();
            jedis.set(key, str);
        } finally {
            close(jedis);
        }
    }

    private void close(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

    /**
     * 把一个字符串转换成bean对象
     * @param str
     * @param <T>
     * @return
     */
    public static <T> T stringToBean(String str, Class<T> clazz) {

        if(str == null || str.length() == 0 || clazz == null) {
            return null;
        }

        if(clazz == int.class || clazz == Integer.class) {
            return (T)Integer.valueOf(str);
        }else if(clazz == String.class) {
            return (T)str;
        }else if(clazz == long.class || clazz == Long.class) {
            return  (T)Long.valueOf(str);
        }else {
            return JSON.toJavaObject(JSON.parseObject(str), clazz);
        }
    }


    public Set<String> getAllKeys() {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.keys("*");
        } finally {
            close(jedis);
        }
    }

}
