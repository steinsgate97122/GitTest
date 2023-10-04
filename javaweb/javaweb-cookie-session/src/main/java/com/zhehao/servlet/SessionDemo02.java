package com.zhehao.servlet;

import com.zhehao.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class SessionDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取或创建用户的session
        HttpSession session = req.getSession();

        resp.setContentType("text/plain; charset=utf-8");

        String name = (String) session.getAttribute("name");
        Person person = (Person) session.getAttribute("person");

        PrintWriter out = resp.getWriter();
        out.write("sessionId等于：" + session.getId() + "\n");
        out.write("name:" + name + "\n");
        out.write("person：" + person + "\n");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
