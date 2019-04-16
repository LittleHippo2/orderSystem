package com.lihao.diancaisystem.serviceImpl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
@Aspect
public class UserCoutrollerAspect {

    @Around("@within(org.springframework.stereotype.Controller)")
    public Object simpleAop(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try{
            Object[] objects = proceedingJoinPoint.getArgs();
            System.out.println("args="+ Arrays.asList(objects));
            //调用原有方法
            Object o = proceedingJoinPoint.proceed();
            System.out.println("o="+o);
            return o;
        }catch(Throwable e){
            throw e;
        }
    }
}
