package com.example.demo.HelloWorld.DbTest.service;

import com.example.demo.HelloWorld.DbTest.entity.User3;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author maxiao
 */
@Service
public interface User3Service {

    List<User3> getAllUsers();

    List<User3> getUserByIds(List<Integer> ids);

    int insert(User3 user3);

    int updateById(User3 user3);
}
