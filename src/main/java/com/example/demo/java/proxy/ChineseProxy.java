package com.example.demo.java.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLIB
 * @author maxiao
 */
public class ChineseProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("-------- CGLIB ---------");
        Object intercept = methodProxy.invokeSuper(o, objects);
        return intercept;
    }
}
