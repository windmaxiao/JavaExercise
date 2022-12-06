package com.example.demo.HelloWorld.TestJava8.StreamTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author maxiao
 */
public class StreamTest {

    /**
     *创建
     */
    public static void testCreatStream(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        Stream<String> stream1 = list.stream();
        stream1.forEach(System.out::println);

        Integer[] nums = new Integer[]{1, 2, 3, 4, 5};
        Stream<Integer> stream2 = Arrays.stream(nums);
        stream2.forEach(System.out::println);

        Stream<String> stream3 = Stream.of("aa", "bb", "cc");
        stream3.forEach(System.out::println);

        Stream<Integer> stream4 = Stream.iterate(0, x -> x + 2);
        stream4.limit(5).forEach(System.out::println);

    }

    public static void testStream() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(5);
        list.add(5);
        list.add(6);
        list.add(6);
        list.add(7);
        list.add(7);


        Stream<Integer> stream1 = list.stream();
        System.out.println("stream.filter");
        stream1.filter(x -> x>6).forEach(System.out::println);

        Stream<Integer> stream2 = list.stream();
        System.out.println("stream.limit");
        stream2.limit(2).forEach(System.out::println);

        Stream<Integer> stream3 = list.stream();
        System.out.println("stream.skip");
        stream3.skip(5).forEach(System.out::println);

        Stream<Integer> stream4 = list.stream();
        System.out.println("stream.distinct");
        stream4.distinct().forEach(System.out::println);
    }

    public static void testStreamMap() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
    }

    public static Stream<Character> getCharacter() {

        return null;
    }


    public static void main(String[] args) {
        //testCreatStream();

        //testStream();

        testStreamMap();
    }
}
