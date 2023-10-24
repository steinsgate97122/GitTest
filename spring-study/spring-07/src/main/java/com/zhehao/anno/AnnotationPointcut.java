package com.zhehao.anno;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

// @Aspect注解标记了这个类是一个切面，@Before和@After定义切点
@Aspect
public class AnnotationPointcut {
    @Before("execution(* com.zhehao.service.UserServiceImpl.*(..))")
    public void before() {
        System.out.println("before~");
    }

    @After("execution(* com.zhehao.service.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("after~");
    }
}
