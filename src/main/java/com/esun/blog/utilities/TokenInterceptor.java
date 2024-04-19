package com.esun.blog.utilities;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import io.micrometer.common.lang.NonNull;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response, @NonNull Object handler)
            throws Exception {
        // 在请求到达处理程序之前执行逻辑
        // 检查用户的 token 是否存在
        String token = request.getHeader("token");
        if (token == null || token.isEmpty()) {
            System.out.println("沒有token");
            // 如果 token 不存在，返回未授权状态码或者重定向到登录页面
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        } else {
            System.out.println("token解析失敗");
            return JWTUtilies.getClaimsByToken(token) != null ? true : false;
        }
        // 如果 token 存在，继续处理请求
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        // 在请求处理程序执行之后、视图渲染之前执行逻辑
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) throws Exception {
        // 在请求处理完成后执行逻辑，即视图渲染完成之后
    }
}
