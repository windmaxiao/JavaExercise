package com.example.demo.java.proxy;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * @author maxiao
 */
public class TestProxy {

    public static void main(String[] args) {

        // JDK代理
        People chinese = new Chinese();
        PeopleInvocationHandler invocationHandler = new PeopleInvocationHandler(chinese);
        People proxy = (People) Proxy.newProxyInstance(chinese.getClass().getClassLoader(), chinese.getClass().getInterfaces(), invocationHandler);
        proxy.sayHello();


        // CGLIB
        ChineseProxy chineseProxy = new ChineseProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Chinese.class);
        enhancer.setCallback(chineseProxy);

        Chinese proxyCgLib = (Chinese)enhancer.create();
        proxyCgLib.sayHello();

    }

}
