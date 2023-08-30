package com.zhehao.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 内存中创建图像
        BufferedImage bufferedImage = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
        // 获取画笔，修改图像信息
        Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, 80, 20);
        graphics.setColor(Color.black);
        graphics.setFont(new Font(null, Font.BOLD, 20));
        graphics.drawString(generateRandomNumber(6), 0, 20);

        // 设置HTTP响应头
        // 响应的内容类型为图像的 JPEG 格式
        resp.setContentType("image/jpeg");
        // 指定响应的过期日期，将过期日期设置为过去的时间，意味着告诉浏览器不要缓存这个响应，始终从服务器获取最新内容
        resp.setDateHeader("expires",-1);
        // 指定浏览器不要缓存
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");
        // 让浏览器3秒自动刷新一次
        resp.setHeader("refresh", "3");

        // 将图片写给浏览器
        ImageIO.write(bufferedImage, "jpg", resp.getOutputStream());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public static String generateRandomNumber(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be a positive integer.");
        }

        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(10);  // Generates a random number between 0 and 9
            sb.append(digit);
        }

        return sb.toString();
    }
}
