package com.esun.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class login {

    @GetMapping("/login")
    public String loginpage(String name) {
        return "hello " + name;
    }

}
