package com.example.demo.java.str;

/**
 * 值传递和引用传递
 * @author maxiao
 */
public class ValueTest {

    /**
     * 基本类型
     * @param num
     */
    static void testInt(int num) {
        num = 100;
        System.out.println("num  =  " + num);
    }

    /**
     * 引用类型
     * @param str
     */
    static void testString(String str) {
        str = "aaaa";
        System.out.println("str  =  " + str);
    }


    static void testStringBuild(StringBuilder sb) {
        sb.append("append");
        System.out.println("sb  =  " + sb);
    }

    static void testStringBuild1(StringBuilder sb) {
        sb = new StringBuilder("new");
        System.out.println("sb  =  " + sb);
    }


    public static void main(String[] args) {

        int num1 = 1;
        System.out.println("num1  =  " + num1);
        testInt(num1);
        System.out.println("num1  =  " + num1);

        System.out.println("------------------------------");

        String str1 = "str";
        System.out.println("str1  =  " + str1);
        testString(str1);
        System.out.println("str1  =  " + str1);

        System.out.println("------------------------------");

        StringBuilder stringBuilder = new StringBuilder("test");
        System.out.println("stringBuilder  =  " + stringBuilder);
        testStringBuild(stringBuilder);
        System.out.println("stringBuilder  =  " + stringBuilder);

        System.out.println("------------------------------");

        StringBuilder stringBuilder1 = new StringBuilder("test");
        System.out.println("stringBuilder1  =  " + stringBuilder1);
        testStringBuild1(stringBuilder1);
        System.out.println("stringBuilder1  =  " + stringBuilder1);

    }
}
