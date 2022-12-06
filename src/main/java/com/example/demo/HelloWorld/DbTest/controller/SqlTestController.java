package com.example.demo.HelloWorld.DbTest.controller;

import com.example.demo.HelloWorld.DbTest.entity.User1;
import com.example.demo.HelloWorld.DbTest.entity.User2;
import com.example.demo.HelloWorld.DbTest.entity.User3;
import com.example.demo.HelloWorld.DbTest.service.JdbcTestService;
import com.example.demo.HelloWorld.DbTest.service.User3Service;
import com.example.demo.HelloWorld.DbTest.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maxiao
 */
@RestController
@RequestMapping("/test/sql")
public class SqlTestController {

    JdbcTestService jdbcTestService;

    UserService userService;

    User3Service user3Service;

    public SqlTestController(JdbcTestService jdbcTestService, UserService userService, User3Service user3Service) {
        this.jdbcTestService = jdbcTestService;
        this.userService = userService;
        this.user3Service = user3Service;
    }

    @GetMapping("/jdbc")
    public ResponseEntity<List<String>> testJdbc() {
        List<String> result = jdbcTestService.getQuerySql("select * from user1 where 1=1");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/myBatis/allUser")
    public ResponseEntity<List<User1>> checkAllUser() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @PostMapping("/myBatis/user")
    public ResponseEntity<User1> checkUserByNamePost(@RequestBody User1 user1) {
        return ResponseEntity.ok(userService.getUserByName(user1.getName()));
    }

    @PostMapping("/myBatis/user2")
    public ResponseEntity<User2> checkUser2ByNamePost(@RequestBody User2 user2) {
        return ResponseEntity.ok(userService.getUser2ByName(user2.getName()));
    }

    @PostMapping("/myBatis/user21")
    public ResponseEntity<List<User2>> checkUsers2ByNamePost(@RequestBody User2 user2) {
        return ResponseEntity.ok(userService.getUsers2ByName(user2.getName()));
    }

    @GetMapping("/myBatis/user")
    public ResponseEntity<User1> checkUserByNameGet(@RequestParam("name") String name) {
        return ResponseEntity.ok(userService.getUserByName(name));
    }

    @PostMapping("/myBatis/addUser")
    public ResponseEntity<List<User1>> insertUser(@RequestBody User1 user1) {
        userService.insertUser(user1.getId(), user1.getName(), user1.getSex(), user1.getAge(), user1.getMoney());
        List<User1> allUser = userService.getAllUser();
        System.out.println(allUser.size());

        return ResponseEntity.ok(allUser);
    }

    @PostMapping("/myBatis/allUser3")
    public ResponseEntity<List<User3>> checkAllUser3() {
        return ResponseEntity.ok(user3Service.getAllUsers());
    }

    @PostMapping("/myBatis/User3")
    public ResponseEntity<List<User3>> checkUser3ByIds(@RequestBody List<Integer> ids) {
        return ResponseEntity.ok(user3Service.getUserByIds(ids));
    }

    @PostMapping("/myBatis/addUser3")
    public Integer insertUser3(@RequestBody User3 user3) {
        return user3Service.insert(user3);
    }

    @PostMapping("/myBatis/User31")
    public ResponseEntity<List<Integer>> a() {
        List<Integer> rs = new ArrayList<>();
        rs.add(1);
        rs.add(2);
        rs.add(3);
        rs.add(4);

        return ResponseEntity.ok(rs);
    }

}
