package com.lihao.diancaisystem.configuration;

import com.lihao.diancaisystem.util.WebMvcConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

@Configuration
    public class MvcConfig implements org.springframework.web.servlet.config.annotation.WebMvcConfigurer {

    @Autowired
    private WebMvcConfigurer webMvcConfigurer;



    public void addInterceptors(InterceptorRegistry registry){

        registry.addInterceptor(webMvcConfigurer)
        //addPathPatterns 用于添加拦截规则
        .addPathPatterns("/**").excludePathPatterns("/css/**","/js/**","/image/**","/user/**");

    }
}
