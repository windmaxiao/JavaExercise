package com.example.demo.HelloWorld.TestJava8.lambdaTest;

import lombok.Data;

/**
 * @author maxiao
 */
@Data
public class User {

    private String name;

    private int age;

    public User() {
        System.out.println("无参构造");
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("有参构造");
    }
}
