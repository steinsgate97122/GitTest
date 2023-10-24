package com.zhehao.log;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

// AfterReturningAdvice接口，用于在目标方法正常返回结果后执行一些额外的逻辑
public class AfterLog implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println(target.getClass().getName() + " " + method.getName() + " " + returnValue);
    }
}
