package com.example.demo.jedis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author maxiao
 */

@Data
@Component
@PropertySource("classpath:/redis.properties")
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {

    private String database;

    private String host;

    private Integer port;

    private String password;

    private Integer timeOut;

}
