package com.albert.springboot03web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class UserLoginController {

    @RequestMapping("/user/login")
    public String user(@RequestParam("userName") String userName,
                       @RequestParam("password") String password,
                       Model model, HttpSession session){

        // 具体的业务
        if (!StringUtils.isEmpty(userName) && "123456".equals(password)){
            session.setAttribute("user", userName);
            return "redirect:/main.html";
            //return "dashboard";
        }

        model.addAttribute("msg", "用户名或密码错误");
        return "index";
    }

}
