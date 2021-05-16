package com.albert.springboot03web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

// 如果我们想diy一些定制化的功能，只要写这个组件，然后将它交给springboot，springboot就会帮我们自动装配

// 以下是扩展 springmvc， dispatcherserlvet
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    // 视图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("h").setViewName("index");
    }

    /*// ViewResolver是实现了视图解析器接口的类，可以把它看做视图解析器
    @Bean
    public ViewResolver myViewResolver(){
        return new MyViewResolver();
    }

    // 自定义一个自己的视图解析器，
    public static class MyViewResolver implements ViewResolver{
        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }*/
}
