package com.zhehao.controller;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Ignore
public class BookControllerTest {
    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookController bookController = context.getBean("bookController", BookController.class);
    }
}
