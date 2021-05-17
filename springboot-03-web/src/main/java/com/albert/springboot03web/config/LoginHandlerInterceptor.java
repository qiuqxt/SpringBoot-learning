package com.albert.springboot03web.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object userName = request.getSession().getAttribute("user");
        if (userName == null){
            request.setAttribute("msg", "没有权限");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;

        }else {
            return true;
        }

    }
}
