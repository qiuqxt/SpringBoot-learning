package com.albert.springboot03web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

// 在templates目录下的所有资源，只能通过controller来跳转
// 以下操作，需要模板引擎的支持，thymeleaf
@Controller
public class IndexController {

    @RequestMapping("a")
    public String index(Model model){
        model.addAttribute("msg","<h1>HelloWorld</h1>");
        model.addAttribute("lists", Arrays.asList("list1","list2","list3"));
        return "index";
    }
}
