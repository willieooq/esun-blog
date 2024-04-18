package com.esun.blog.utilities;

import org.springframework.web.servlet.HandlerInterceptor;

import io.micrometer.common.lang.NonNull;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("LoginInterceptor");
        return true;
    }
}
