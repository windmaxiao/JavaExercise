package com.example.demo.HelloWorld.DbTest.service.impl;

import com.example.demo.HelloWorld.DbTest.entity.User3;
import com.example.demo.HelloWorld.DbTest.mappers.User3Mapper;
import com.example.demo.HelloWorld.DbTest.service.User3Service;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author maxiao
 */
@Service
@Log4j2
public class User3ServiceImpl implements User3Service {

    User3Mapper user3Mapper;

    public User3ServiceImpl(User3Mapper user3Mapper) {
        this.user3Mapper = user3Mapper;
    }

    @Override
    public List<User3> getAllUsers() {
        return user3Mapper.selectList(null);
    }

    @Override
    public List<User3> getUserByIds(List<Integer> ids) {
        return user3Mapper.selectBatchIds(ids);
    }

    @Override
    public int insert(User3 user3) {
        return user3Mapper.insert(user3);
    }

    @Override
    public int updateById(User3 user3) {
        return user3Mapper.updateById(user3);
    }
}
