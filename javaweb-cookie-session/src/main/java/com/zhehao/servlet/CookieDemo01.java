package com.zhehao.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置req和resp编码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/plain; charset=utf-8");

        // 获取客户端送来的Cookie
        Cookie[] cookies = req.getCookies();

        // 获取输出对象
        PrintWriter out = resp.getWriter();
        boolean flag = false;

        // 遍历Cookie
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                // 客户端非初次访问会带上time，输出上次访问的时间
                if (cookie.getName().equals("time")) {
                    long formerTime = Long.parseLong(cookie.getValue());
                    Date date = new Date(formerTime);
                    out.write("非首次访问，上次访问时间：" + date.toString());
                    flag = true;
                }
            }
        }

        // 没有遍历到time
        if(!flag) {
            out.write("首次访问");
        }

        // 设置cookie，内容为服务器当前时间
        Cookie cookie = new Cookie("time", System.currentTimeMillis() + "");
        // 设置cookie有效期30秒
        cookie.setMaxAge(30);
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
