package com.zhehao.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RequestTest extends HttpServlet {
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWD = "123";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // req可获取前端传递的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWD)) {
            req.getRequestDispatcher("success.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
