package com.example.demo.HelloWorld.DbTest.dao;

import com.example.demo.HelloWorld.DbTest.entity.User2;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * XML配置的mybatis
 * @author maxiao
 */
@Mapper
public interface User2Dao {

    /**
     * name
     * @param name name
     * @return User2
     */
    User2 getUser2ByName(String name);

    List<User2> getUser2ByName1(String name);

}
