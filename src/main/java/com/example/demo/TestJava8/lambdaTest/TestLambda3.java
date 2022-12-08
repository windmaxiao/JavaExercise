package com.example.demo.TestJava8.lambdaTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 集合中的lambda
 * @author maxiao
 */
public class TestLambda3 {

    public static void main(String[] args) {
        listLambdaTest();
    }


    public static void listLambdaTest() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);

        System.out.println("排序前：" + list);
        list.sort((n1,n2) -> n1 - n2);
        System.out.println("排序后：" + list);

        list.sort((n1,n2) -> n2 - n1);
        list.forEach(System.out::println);
    }


}
