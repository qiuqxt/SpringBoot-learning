package com.albert.springboot03web.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

// 可以在链接上携带区域信息
public class MyLocaleResolver implements LocaleResolver {

    // 解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {

        // 获取请求信息
        String language = request.getParameter("l");
        Locale locale = Locale.getDefault();    // 如果没有获取到，就是用系统默认的

        if (!StringUtils.isEmpty(language)){
            String[] split = language.split("_");
            // 国家，地区
            locale = new Locale(split[0],split[1]);
        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
