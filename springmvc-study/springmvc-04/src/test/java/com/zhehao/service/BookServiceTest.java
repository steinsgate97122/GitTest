package com.zhehao.service;

import com.zhehao.pojo.Books;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@Ignore
public class BookServiceTest {
    @Test
    public void testQueryAllBooks() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean("bookServiceImpl", BookServiceImpl.class);
        List<Books> books = bookService.queryAllBooks();
        System.out.println(books);
    }
}
