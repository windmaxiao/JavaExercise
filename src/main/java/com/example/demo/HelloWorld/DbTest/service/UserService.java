package com.example.demo.HelloWorld.DbTest.service;

import com.example.demo.HelloWorld.DbTest.entity.User1;
import com.example.demo.HelloWorld.DbTest.entity.User2;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author maxiao
 */
@Service
public interface UserService {

    public User1 getUserByName(String name);

    public User2 getUser2ByName(String name);

    public List<User2> getUsers2ByName(String name);

    public List<User1> getAllUser();

    public void insertUser(int id, String name, String sex, Integer age, BigDecimal money);

    public void updateUser(String name, String sex, Integer age, BigDecimal money, int id);

    public void deleteUser(int id);

    public void changeMoney(int id, String name, BigDecimal money);
}
