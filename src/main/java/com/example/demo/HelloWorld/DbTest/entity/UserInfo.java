package com.example.demo.HelloWorld.DbTest.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.IntBinaryOperator;

/**
 * @author maxiao
 */
@Data
public class UserInfo {

    private int id;

    private String name;

    private String sex;

    private int age;

    private BigDecimal money;

    private StringBuffer sb;

    private StringBuilder sb1;

    private Map<String, Integer> map = new HashMap<>();

    private Map<String, Integer> map1 = new ConcurrentHashMap<String, Integer>();

    private List<String> list = new ArrayList<>();

    private Vector<String> vector;



}
