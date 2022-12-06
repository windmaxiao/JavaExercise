package com.example.demo.HelloWorld.DbTest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author maxiao
 */
@Data
@TableName("user3")
public class User3 {

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private String name;

    private String sex;

    private int age;

    private BigDecimal money;


}
