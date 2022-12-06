package com.example.demo.HelloWorld.testProperties.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author maxiao
 */
@PropertySource("classpath:testProperties.yml")
@Component
@Getter
@Setter
public class TestProperties {

    /**
     * 不推荐这种方式
     */
    @Value("${url}")
    private String url;
    
}
