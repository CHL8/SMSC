package com.hp.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String servletPath = request.getServletPath();
//        System.out.println("servletPath = " + servletPath);
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        return true;
    }
}
