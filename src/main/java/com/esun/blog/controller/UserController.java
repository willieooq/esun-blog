package com.esun.blog.controller;

import org.springframework.web.bind.annotation.RestController;

import com.esun.blog.mapper.UsersMapper;
import com.esun.blog.model.po.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/*
使用者登入
使用者註冊
*/
@RestController
public class UserController {

    @Autowired
    private UsersMapper userMapper;

    // 取得用戶資料
    @GetMapping("/user")
    public List<User> query() {
        List<User> users = userMapper.selectList(null);
        return users;
    }

    // 新增用戶
    @PostMapping("/register")
    public String addUser(@RequestBody User user) {
        // return user.toString();
        System.out.println(user.toString());
        // int i = userMapper.addUser(user);
        int i = userMapper.insert(user);

        return (i > 0) ? "新增成功" : "新增失敗";
    }

    @PostMapping("/posttest")
    public String postTest(@RequestBody String username) {
        // TODO: process POST request

        return "test: " + username;
    }

}
