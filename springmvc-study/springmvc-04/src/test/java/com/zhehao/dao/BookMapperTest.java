package com.zhehao.dao;

import com.zhehao.pojo.Books;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@Ignore
public class BookMapperTest {
    @Test
    public void testQueryAllBooks() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookMapper bookMapper = context.getBean("bookMapper", BookMapper.class);
        List<Books> books = bookMapper.queryAllBooks();
        System.out.println(books);
    }

    @Test
    public void testQueryBook() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookMapper bookMapper = context.getBean("bookMapper", BookMapper.class);
        List<Books> books = bookMapper.queryBook("bird");
        System.out.println(books);
    }

    @Test
    public void testQueryBookByName() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookMapper bookMapper = context.getBean("bookMapper", BookMapper.class);
        Books books = bookMapper.queryBookByName("1984");
        System.out.println(books);
    }

    @Test
    public void testQueryBookById() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookMapper bookMapper = context.getBean("bookMapper", BookMapper.class);
        Books books = bookMapper.queryBookById(2);
        System.out.println(books);
    }

    @Test
    public void testAddBook() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookMapper bookMapper = context.getBean("bookMapper", BookMapper.class);
        Books books = new Books();
        books.setBookCount(40);
        books.setBookName("Moby-Dick");
        books.setDetail("Novel by Herman Melville");
        bookMapper.addBook(books);
    }

    @Test
    public void testUpdateBook() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookMapper bookMapper = context.getBean("bookMapper", BookMapper.class);
        Books books = bookMapper.queryBookById(1);
        books.setBookCount(books.getBookCount() + 1);
        bookMapper.updateBook(books);
    }

    @Test
    public void testDeleteBookById() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookMapper bookMapper = context.getBean("bookMapper", BookMapper.class);
        bookMapper.deleteBookById(4);
    }
}
