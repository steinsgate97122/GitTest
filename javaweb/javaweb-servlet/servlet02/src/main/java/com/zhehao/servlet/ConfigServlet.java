package com.zhehao.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

public class ConfigServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        // 使用mvn package命令进行构建时，src/main/resources下的配置文件会被复制到WEB-INF/classes目录下
        InputStream inputStream = servletContext.getResourceAsStream("/WEB-INF/classes/config.properties");

        Properties properties = new Properties();
        properties.load(inputStream);

        String url = properties.getProperty("db.url");
        String username = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");

        PrintWriter writer = resp.getWriter();
        writer.println("url:" + url);
        writer.println("username:" + username);
        writer.println("password:" + password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
