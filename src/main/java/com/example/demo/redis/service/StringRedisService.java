package com.example.demo.redis.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * StringRedisTemplate 操作key和value都是字符串
 * @author maxiao
 */
@Service
public class StringRedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /*=========================================== 基本操作 ===================================================*/

    /**
     * DEL 命令
     * @param key
     * @return
     */
    public Boolean deleteKey(String key) {
        return stringRedisTemplate.delete(key);
    }

    /**
     * RENAME 命令
     * RENAMENX 命令
     * @param key
     * @param newKey
     */
    public void renameKey(String key, String newKey) {
        stringRedisTemplate.rename(key, newKey);
        stringRedisTemplate.renameIfAbsent(key, newKey);
    }

    /**
     * EXISTS 命令
     * @param key
     * @return
     */
    public Boolean hasKey(String key) {
        return stringRedisTemplate.hasKey(key);
    }

    /**
     * TYPE 命令
     * @param key
     * @return
     */
    public String keyType(String key) {
        DataType type = stringRedisTemplate.type(key);
        if (type != null) {
            return type.name();
        } else {
            return null;
        }
    }

    /**
     * KEYS 命令
     * @param pattern
     * @return
     */
    public Set<String> getKeys(String pattern) {
        return stringRedisTemplate.keys(pattern);
    }
    /*=========================================== 基本操作 ===================================================*/

    /*===========================================String 数据类型操作===================================================*/
    /**
     * String 类型的 GET 命令
     * @param key key
     * @return
     */
    public String getStringValue(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * String 的 SET 命令
     * @param key
     * @param value
     */
    public void setStringValue(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }



    /*===========================================String 数据类型操作===================================================*/

    /*===========================================List 数据类型操作===================================================*/

    /**
     * LPUSH
     * @param key
     * @param index
     * @param value
     */
    public void leftPushList(String key, String value) {
        stringRedisTemplate.opsForList().leftPush(key, value);
    }

    /**
     * LRANGE
     * @param key
     * @return
     */
    public List<String> getList(String key) {
        return stringRedisTemplate.opsForList().range(key, 0, -1);
    }



    /*===========================================List 数据类型操作===================================================*/

}
