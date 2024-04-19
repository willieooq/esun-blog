package com.esun.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.esun.blog.mapper.UsersMapper;
import com.esun.blog.model.po.User;
import com.esun.blog.utilities.Result;

/**
 * 密碼加密 encryptPassword(String password)
 * 驗證密碼正確 matchesPassword(String rawPassword, String encodedPassword)
 * 用戶是否存在 isUserExist(User user)
 * 登入邏輯處理 loginService(User user)
 * 註冊邏輯處理 registerService(User user)
 */
@Service
public class UserService {
    @Autowired
    UsersMapper userMapper;

    /**
     * 生成BCryptPasswordEncoder密码
     *
     * @param password 密码
     * @return 加密字符串
     */
    public static String encryptPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    /**
     * 判断密码是否相同
     *
     * @param rawPassword     真实密码
     * @param encodedPassword 加密后字符
     * @return 结果
     */
    public static boolean matchesPassword(String rawPassword, String encodedPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public User getUserData(Integer userId) {
        User exist = userMapper.selectById(userId);
        exist.setPassword(null);
        return (exist != null && exist.getUserId() != null) ? exist : null;
    }

    public Result loginService(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        List<User> users = userMapper.selectList(new QueryWrapper<User>().like("username", username));
        for (User exist : users) {
            if (matchesPassword(password, exist.getPassword())) {
                return Result.ok().data("userId", exist.getUserId());
            }
        }
        return Result.failure();
    }

    public boolean registerService(User user) {
        if (userMapper.selectList(new QueryWrapper<User>().like("username", user.getUsername())).isEmpty()) {
            user.setPassword(encryptPassword(user.getPassword()));
            return userMapper.insert(user) > 0 ? true : false;
        }
        return false;
    }
}
