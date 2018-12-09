package com.iamya.boot.crud.interceptor;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器,拦截没有登录的用户
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object loginUser = request.getSession().getAttribute("loginUser");
        if (StringUtils.isEmpty(loginUser)) {
            request.setAttribute("msg", "没有权限,请登录后访问");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }

        return true;

    }
}
