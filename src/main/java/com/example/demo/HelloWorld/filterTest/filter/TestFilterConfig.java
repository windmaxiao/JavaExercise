package com.example.demo.HelloWorld.filterTest.filter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.FilterRegistration;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author maxiao
 */
@Configuration
public class TestFilterConfig {

    @Autowired
    TestFilter testFilter;

    public FilterRegistrationBean<TestFilter> testFilter () {
        FilterRegistrationBean<TestFilter> filterRegistrationBean = new FilterRegistrationBean<>();

        filterRegistrationBean.setFilter(testFilter);

        filterRegistrationBean.setUrlPatterns(new ArrayList<>(Arrays.asList("*/test/*")));

        // 顺序
        filterRegistrationBean.setOrder(1);

        return filterRegistrationBean;

    }
}
