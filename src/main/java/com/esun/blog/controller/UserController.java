package com.esun.blog.controller;

import org.springframework.web.bind.annotation.RestController;

import com.esun.blog.mapper.UsersMapper;
import com.esun.blog.model.po.User;
import com.esun.blog.service.UserService;
import com.esun.blog.utilities.JWTUtilies;
import com.esun.blog.utilities.Result;
import com.esun.blog.utilities.StatusCode;

import io.jsonwebtoken.Claims;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 使用者登入 login(@RequestBody User user)
 * 取得用戶資料 getUserInfo(@RequestHeader("token") String token)
 * 取得全部用戶資料 query()
 * 使用者註冊 addUser(@RequestBody User user)
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UsersMapper userMapper;
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        Result userId = userService.loginService(user);
        if (userId.getCode() == StatusCode.SUCCESS) {
            String token = JWTUtilies.generateAccessToken(Integer.parseInt(userId.getData().get("userId").toString()));
            return Result.ok().data("token", token);
        }
        return Result.failure().data("message", "用戶名稱或密碼錯誤");
    }

    @GetMapping("/info")
    public Result getUserInfo(@RequestHeader("token") String token) {
        try {
            String userId = JWTUtilies.getClaimsByToken(token).getSubject();
            User user = userService.getUserData(Integer.parseInt(userId));
            return user != null ? Result.ok().data("userInfo", user)
                    : Result.failure().data("message", String.format("找不到id為{}的使用者", userId));
        } catch (Exception e) {
            // Handle other exceptions
            return Result.failure().data("message", "無效的token");
        }
    }

    // 取得全部用戶資料
    @GetMapping("/all")
    public List<User> query() {
        List<User> users = userMapper.selectList(null);
        return users;
    }

    // 新增用戶
    @PostMapping("/register")
    public Result addUser(@RequestBody User user) {
        return userService.registerService(user) ? Result.ok().data("message", "新增成功")
                : Result.failure()
                        .data("message", "此使用者已存在");
    }

}
