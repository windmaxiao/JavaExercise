package com.example.demo.HelloWorld.TestJava8.lambdaTest;

/**
 * lambda构造方法引用
 * @author maxiao
 */
public class TestLambda2 {

    public static void main(String[] args) {
        UserService userService = User::new;
        System.out.println(userService.getUser());

        UserService1 userService1 = User::new;
        System.out.println(userService1.getUser("aaa", 2));
    }



    interface UserService{
        User getUser();
    }

    interface UserService1{
        User getUser(String name, int age);
    }
}
