package com.zhehao.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    /*
    * Servlet是Java中用于处理HTTP请求和响应的基础类，而HttpServlet是Servlet的子类，封装了HTTP协议相关的功能
    * 当浏览器发起GET请求时，Servlet容器会调用Servlet的doGet方法来处理该请求；
    * 当浏览器发起POST请求时，Servlet容器会调用Servlet的doPost方法来处理该请求
    * 重写doGet和doPost方法时，可以通过HttpServletRequest对象获取请求参数、请求头信息等
    * 通过HttpServletResponse对象设置响应内容、状态码等
    * */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("Hello");
        writer.println(this.getServletConfig());
        writer.println(this.getServletContext());

        // ServletContext对象在Web应用的整个生命周期内都存在，类似全局容器，可以在不同Servlet之间共享数据
        ServletContext servletContext = this.getServletContext();
        servletContext.setAttribute("name", "zhangzhehao01");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
