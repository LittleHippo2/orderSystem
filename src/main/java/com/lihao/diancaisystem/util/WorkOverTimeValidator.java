package com.lihao.diancaisystem.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class WorkOverTimeValidator implements ConstraintValidator<WorkOverTime ,Integer> {

    WorkOverTime work;

    int max;

    public void initialize(WorkOverTime work){
        this.work = work;
        //获取注解的定义
        max = work.max();
    }

    public boolean isValid(Integer value , ConstraintValidatorContext context){
        //校验逻辑
        if(value ==null){
            return true;
        }
        return  value<max;
    }
}
