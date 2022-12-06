package com.example.demo.HelloWorld.DbTest.service.impl;

import com.example.demo.HelloWorld.DbTest.dao.User1Dao;
import com.example.demo.HelloWorld.DbTest.dao.User2Dao;
import com.example.demo.HelloWorld.DbTest.entity.User1;
import com.example.demo.HelloWorld.DbTest.entity.User2;
import com.example.demo.HelloWorld.DbTest.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author maxiao
 */
@Service
@Log4j2
public class UserServiceImpl implements UserService   {

    User1Dao user1Dao;

    User2Dao user2Dao;

    public UserServiceImpl(User1Dao user1Dao, User2Dao user2Dao) {
        this.user1Dao = user1Dao;
        this.user2Dao = user2Dao;
    }

    @Override
    public User1 getUserByName(String name) {
        log.debug("getUserByName===========");
        return user1Dao.findUserByName(name);
    }

    @Override
    public User2 getUser2ByName(String name) {
        log.debug("getUser2ByName===========");
        return user2Dao.getUser2ByName(name);
    }

    @Override
    public List<User2> getUsers2ByName(String name) {
        log.debug("getUser2ByName===========");
        return user2Dao.getUser2ByName1(name);
    }

    @Override
    public List<User1> getAllUser() {
        log.debug("getAllUser===========");
        return user1Dao.getAllUser();
    }

    @Override
    public void insertUser(int id, String name, String sex, Integer age, BigDecimal money) {
        log.debug("insertUser===========");
        user1Dao.insertUser(id, name, sex, age, money);
    }

    @Override
    public void updateUser(String name, String sex, Integer age, BigDecimal money, int id) {
        log.debug("updateUser===========");
        user1Dao.updateUser(name, sex, age, money, id);
    }

    @Override
    public void deleteUser(int id) {
        log.debug("deleteUser===========");
        user1Dao.deleteUser(id);
    }

    @Override
    public void changeMoney(int id, String name, BigDecimal money) {

    }
}
