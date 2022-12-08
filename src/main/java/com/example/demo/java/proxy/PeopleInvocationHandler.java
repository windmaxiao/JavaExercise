package com.example.demo.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * JDK代理
 * @author maxiao
 */
public class PeopleInvocationHandler implements InvocationHandler {

    private final People people;

    PeopleInvocationHandler(People people) {
        this.people = people;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("------ JDK 代理 --------");
        Object invoke = method.invoke(people, args);

        return invoke;
    }
}
