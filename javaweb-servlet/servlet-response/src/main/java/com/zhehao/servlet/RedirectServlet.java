package com.zhehao.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 浏览器收到重定向响应后，会立即发起一个新的请求，访问重定向后的URL。这导致在浏览器地址栏中显示重定向后的URL。
        // 这个过程中客户端和服务器之间会有两次通信，原始请求和重定向请求
        resp.sendRedirect("/servlet-response-1.0-SNAPSHOT/image");

        // servlet02中有使用servletContext.getRequestDispatcher().forward()
        // 实现的是服务器内部的页面跳转，不会产生新的HTTP请求，不会更改浏览器地址栏中的URL
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
