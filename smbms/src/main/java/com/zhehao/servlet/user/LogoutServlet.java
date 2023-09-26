package com.zhehao.servlet.user;

import com.zhehao.pojo.User;
import com.zhehao.service.user.UserServiceImpl;
import com.zhehao.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    // 控制层
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 退出登录，移除Constants.USER_SESSION
        req.getSession().removeAttribute(Constants.USER_SESSION);

        // 重定向到登录页
        resp.sendRedirect(req.getContextPath() + "/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
