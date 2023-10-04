package com.zhehao.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 文件路径
        String filePath = "/Users/zhangzhehao01/Git/GitTest/javaweb-servlet/servlet-response/src/main/resources/aiprint.png";
        // 文件名，获取到最后一个"/"的索引
        String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
        // 设置下载的header
        resp.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        // 输入流读取本地文件
        FileInputStream inputStream = new FileInputStream(filePath);
        int len = 0;
        byte[] buffer = new byte[1024];
        // 获取输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        // 写入输出流
        while((len = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }
        inputStream.close();
        outputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
