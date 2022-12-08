package com.example.demo.TestJava8.lambdaTest;

/**
 * Lambda 常用语法
 * @author maxiao
 */
public class TestLambda {

    public static void main(String[] args) {

        NoParamsTest noParamsTest = () -> {return 1;};
        OneParamsTest oneParamsTest = (int x) -> {return x;};
        TwoParamsTest twoParamsTest = (int x, int y) -> {return x + y;};

        NoReturnTest noReturnTest = () -> {
            System.out.println("noReturnTest");
        };

        NoReturnTest1 noReturnTest1 = (int x) -> {
            System.out.println(x);
        };
        // 类型可省略
        NoReturnTest1 noReturnTest11 = (x) -> {
            System.out.println("类型可省略");
        };

        // 一个参数，括号亦可省略
        NoReturnTest1 noReturnTest111 = x -> {
            System.out.println("一个参数，括号亦可省略");
        };

        // 函数体一个语句，无返回值，括号亦可省略
        NoReturnTest1 noReturnTest1111 = x -> System.out.println("函数体一个语句，无返回值，括号亦可省略");

        // 只有返回值，大括号需要和return一起去掉
        NoParamsTest noParamsTest1 = () -> 1;

        NoReturnTest2 noReturnTest2 = (int x, int y) -> {
            System.out.println(x + y);
        };

        NoReturnTest2 noReturnTest22 = (x, y) -> {
            System.out.println(x + y);
        };

    }


    interface NoParamsTest {
        int add();
    }

    interface OneParamsTest {
        int add(int x);
    }

    interface TwoParamsTest {
        int add(int x, int y);
    }

    interface NoReturnTest {
        void add();
    }

    interface NoReturnTest1 {
        void add(int x);
    }

    interface NoReturnTest2 {
        void add(int x, int y);
    }


}
