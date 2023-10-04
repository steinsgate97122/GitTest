package com.zhehao.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        // 先访问HelloServlet类，这里才能获取到"name"属性，实现数据共享
        String name = (String) servletContext.getAttribute("name");

        PrintWriter writer = resp.getWriter();
        writer.println("name: " + name);

        // 可获取web.xml中配置的<context-param>参数
        String age = servletContext.getInitParameter("age");
        writer.println("age: " + age);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
