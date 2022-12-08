package com.example.demo.TestJava8.lambdaTest;

/**
 * lambda方法引用
 * @author maxiao
 */
public class TestLambda1 {

    public static void main(String[] args) {

        TestLambda1 testLambda1 = new TestLambda1();
        Aa aa = testLambda1::testAa;

        System.out.println(aa.test(3));

        Aa aa1 = TestLambda1::testBb;
        System.out.println(aa1.test(4));
    }

    public int testAa(int a) {
        return a-3;
    }

    public static int testBb(int a) {
        return a-3;
    }

    interface Aa {
        int test(int a);
    }
}
