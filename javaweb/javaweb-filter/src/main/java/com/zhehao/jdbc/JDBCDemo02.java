package com.zhehao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "zhang97122";

        // 加载数据库驱动程序，通过反射实现
        Class.forName("com.mysql.jdbc.Driver");

        // 建立数据库连接，connection代表当前数据库
        Connection connection = DriverManager.getConnection(url, username, password);

        // 预编译语句可多次执行提高性能，避免重复编译，还可以防止sql注入，适合执行带参数的sql
        String sql = "INSERT INTO `people`(`name`, `age`, `address`) VALUES (?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // 设置字符串参数值
        preparedStatement.setString(1, "zzy");
        preparedStatement.setString(2, "26");
        preparedStatement.setString(3, "brisbane");

        // executeUpdate执行更新语句（非查询语句）
        int i = preparedStatement.executeUpdate();

        if(i > 0) {
            System.out.println("insert success");
        }

        // 释放资源
        preparedStatement.close();
        connection.close();
    }
}
