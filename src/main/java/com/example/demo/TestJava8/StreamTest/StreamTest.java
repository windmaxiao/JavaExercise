package com.example.demo.TestJava8.StreamTest;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
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
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd", "ee");
        System.out.println("map test");
        list.stream().map(String::toUpperCase).forEach(System.out::println);

        System.out.println("map test2");
        Stream<Stream<Character>> stream = list.stream().map(StreamTest::getCharacter);
        stream.forEach(s -> s.forEach(System.out::println));

        System.out.println("flatMap test");
        Stream<Character> stream1 = list.stream().flatMap(StreamTest::getCharacter);
        stream1.forEach(System.out::println);
    }

    public static Stream<Character> getCharacter(String str) {
        List<Character> list = new ArrayList<>();

        for (Character ch: str.toCharArray()) {
            list.add(ch);
        }

        return list.stream();
    }

    public static void testStreamSort() {
        List<String> list = Arrays.asList("ee", "dddd", "cccc", "bbbbb", "a");

        System.out.println("排序前");
        list.forEach(System.out::println);

        System.out.println("排序后-sorted()");
        list.stream().sorted().forEach(System.out::println);

        System.out.println("排序后-sorted(Comparator<? super T> comparator)");
        list.stream().sorted((s1, s2) -> s2.length() - s1.length()).forEach(System.out::println);
    }

    public static void testStreamReduce() {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e");

        String str = list.stream().reduce("reduce=", (x, y) -> x + y);

        System.out.println(str);

        List<User> users = Arrays.asList(new User("A", 1, true), new User("B", 2, true),
                new User("C", 3, false), new User("D", 4, false));

        Optional<Integer> sum = users.stream().map(User::getAge).reduce(Integer::sum);

        System.out.println(sum.get());
    }

    public static void testStreamCollect() {
        List<User> users = Arrays.asList(new User("A", 1, true), new User("B", 2, true),
                new User("C", 3, false), new User("D", 4, false));

        users.stream().map(User::getName).collect(Collectors.toList()).forEach(System.out::println);

        Map<String, User> map = users.stream().collect(Collectors.toMap(User::getName, Function.identity()));
        map.forEach((key, value) -> {
            System.out.println(key + "==" + value.toString());
        });

        Map<Boolean, List<User>> map1 = users.stream().collect(Collectors.groupingBy(User::getOk));
        map1.forEach((key, value) -> {
            System.out.println(key + "==" + value);
        });

        String str = users.stream().map(User::getName).collect(Collectors.joining());
        String str1 = users.stream().map(User::getName).collect(Collectors.joining(",", "+", "-"));
        System.out.println(str);
        System.out.println(str1);
    }



    public static void main(String[] args) {

        testCreatStream();

        testStream();

        testStreamMap();

        testStreamSort();

        testStreamReduce();

        testStreamCollect();
    }
}
