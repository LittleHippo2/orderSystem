package com.lihao.diancaisystem.util;

import com.lihao.diancaisystem.po.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class WebMvcConfigurer implements HandlerInterceptor {

    private  final Logger logger = LoggerFactory.getLogger(WebMvcConfigurer.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            //如果没有登录，就定向到登录页面
            response.sendRedirect("/user/login");
            return  false;
        }
        logger.info("当前用户已登录，登录的用户为："+user.getName());
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //controller 方法调用完毕后执行的方法
        logger.info("方法执行完毕");
        System.out.println("方法执行完毕");
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //页面渲染完毕后调用此方法，通常用来清除某些资源，类似java语法的finally
        logger.info("页面渲染完了，能执行几次");
        System.out.println("页面渲染完了，能执行几次");
    }
}
