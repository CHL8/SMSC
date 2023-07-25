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
        String servletPath = request.getServletPath();
        System.out.println("servletPath = " + servletPath);
        String[] split = servletPath.split("/");
        if(split.length>=2 && split[1].equals("admin")){
            HttpSession session = request.getSession();
            Object admin = session.getAttribute("admin");
            if(admin==null){
                response.sendRedirect("/admin/login");
                return false;
            }
        }
        return true;
    }
}
