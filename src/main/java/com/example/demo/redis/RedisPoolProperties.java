package com.example.demo.redis;

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
@ConfigurationProperties(prefix = "spring.redis.pool")
public class RedisPoolProperties {

    private Integer maxActive;

    private Integer maxWait;

    private Integer maxIdle;

    private Integer minIdle;

}
