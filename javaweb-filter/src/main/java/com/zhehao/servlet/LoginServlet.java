package com.zhehao.servlet;

import com.zhehao.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收username，鉴权决定是否登录成功
        String username = req.getParameter("username");

        if((username != null) && username.equals("admin")) {
            // 用户登录后，往Session中存放用户的数据
            req.getSession().setAttribute(Constant.USER_SESSION, req.getSession().getId());
            resp.sendRedirect(req.getContextPath() + "/sys/success.jsp");
        } else {
            resp.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
