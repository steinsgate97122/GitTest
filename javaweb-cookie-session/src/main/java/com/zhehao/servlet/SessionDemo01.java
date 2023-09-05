package com.zhehao.servlet;

import com.zhehao.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class SessionDemo01 extends HttpServlet {
    /*
    * Cookie存储在客户端；Session存储在服务端
    * Cookie存储在客户端的文本文件中，存储少量数据；Session存储一些敏感数据
    * Session的安全性更高
    * Session将数据存储在服务端，会增加服务端的负担
    * */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取或创建用户的session
        HttpSession session = req.getSession();

        resp.setContentType("text/plain; charset=utf-8");

        PrintWriter out = resp.getWriter();
        out.write("sessionId等于：" + session.getId());

        // value可以被设置为任何Object
        session.setAttribute("name", "zhehao");
        Person person = new Person("zhehao", 26);
        session.setAttribute("person", person);

        /*
        * ServletContext的用法类似，通常用于存储全局数据，对于所有用户和请求都可见。它在整个应用程序中都可用，不依赖于特定用户的会话。
        * Session用于在服务器和客户端之间维护用户状态，每个用户都有自己的Session，通常与用户的浏览器会话相关联
        * */
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
