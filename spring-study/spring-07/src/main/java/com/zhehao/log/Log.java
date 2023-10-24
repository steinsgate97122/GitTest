package com.zhehao.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/*
MethodBeforeAdvice是一个通知接口，用于在目标方法执行之前执行一些额外的逻辑
 */
public class Log implements MethodBeforeAdvice {
    // method被调用的目标方法，args目标方法的参数，target被代理的目标对象
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println(target.getClass().getName() + " " + method.getName());
    }
}
