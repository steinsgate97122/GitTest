package com.zhehao.servlet;

import com.zhehao.pojo.User;
import com.zhehao.utils.SendMail;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String email = req.getParameter("email");

            User user = new User(username, password, email);
            SendMail sendMail = new SendMail(user);
            sendMail.start();

            req.setAttribute("message", "send success");
            req.getRequestDispatcher("/info.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("message", "send failed");
            req.getRequestDispatcher("/info.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
