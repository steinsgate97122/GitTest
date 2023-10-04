package com.zhehao.servlet.user;

import com.zhehao.pojo.User;
import com.zhehao.service.user.UserServiceImpl;
import com.zhehao.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    // 控制层
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取前端参数
        String username = req.getParameter("userCode");
        String password = req.getParameter("userPassword");

        // Service层判断是否登录成功
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.login(username, password);

        if (user != null) {
            // 登录成功，设置Constants.USER_SESSION
            req.getSession().setAttribute(Constants.USER_SESSION, user);
            resp.sendRedirect(req.getContextPath() + "/jsp/frame.jsp");
        } else {
            // 登录失败
            req.setAttribute("error", "用户名或密码错误");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
