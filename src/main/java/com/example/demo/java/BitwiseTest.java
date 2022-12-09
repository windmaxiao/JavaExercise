package com.example.demo.java;

/**
 * @author maxiao
 */
public class BitwiseTest {

    public static void left() {
        System.out.println("================左移=====================");
        int leftShift = 10;
        System.out.println("十进制:" + leftShift + ", 二进制:" + Integer.toBinaryString(leftShift));
        int newLeftShift = leftShift << 2;
        //正整数x左移n位后的十进制结果，x = x * 2^n
        System.out.println("左移2位后十进制:" + newLeftShift + ", 左移2位后二进制:" + Integer.toBinaryString(newLeftShift));

        int leftShift1 = -10;
        System.out.println("十进制:" + leftShift1 + ", 二进制:" + Integer.toBinaryString(leftShift1));
        int newLeftShift1 = leftShift1 << 2;
        //负整数x左移n位后的十进制结果，x = (|x| + 2^n)
        System.out.println("左移2位后十进制:" + newLeftShift1 + ", 左移2位后二进制:" + Integer.toBinaryString(newLeftShift1));
    }

    public static void right() {
        System.out.println("================右移=====================");
        int rightShift = 10;
        System.out.println("十进制:" + rightShift + ", 二进制:" + Integer.toBinaryString(rightShift));
        int newRightShift = rightShift >> 2;
        //右移n位后的运算数x十进制结果，x = x / 2
        System.out.println("右移2位后十进制:" + newRightShift + ", 右移2位后二进制:" + Integer.toBinaryString(newRightShift));

        int rightShift1 = -10;
        System.out.println("十进制:" + rightShift1 + ", 二进制:" + Integer.toBinaryString(rightShift1));
        int newRightShift1 = rightShift1 >> 2;
        //右移n位后的运算数x十进制结果，x = x / 2
        System.out.println("右移2位后十进制:" + newRightShift1 + ", 右移2位后二进制:" + Integer.toBinaryString(newRightShift1));
    }

    public static void main(String[] args) {
        left();
        right();
    }
}
