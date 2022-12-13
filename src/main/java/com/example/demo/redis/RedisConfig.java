package com.example.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author maxiao
 */
@Configuration
public class RedisConfig {


    @Autowired
    RedisProperties redisProperties;

    @Autowired
    RedisPoolProperties redisPoolProperties;

    @Bean
    public Jedis singleJedis(){
        return new Jedis(redisProperties.getHost(), redisProperties.getPort());
    }

    @Bean
    public JedisPool jedisPool() {

        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(redisPoolProperties.getMaxIdle());
        poolConfig.setMaxTotal(redisPoolProperties.getMaxActive());
        poolConfig.setMaxWaitMillis(redisPoolProperties.getMaxWait() * 1000);

        return new JedisPool(poolConfig, redisProperties.getHost(), redisProperties.getPort(),
                redisProperties.getTimeOut()*1000, redisProperties.getPassword(), 0);
    }

}
