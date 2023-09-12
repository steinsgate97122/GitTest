package com.zhehao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "zhang97122";

        // 加载数据库驱动程序，通过反射实现
        Class.forName("com.mysql.jdbc.Driver");

        // 建立数据库连接，connection代表当前数据库
        Connection connection = DriverManager.getConnection(url, username, password);

        // 创建用于执行SQL语句的statement对象，用来CRUD，适合执行不带参数的sql，安全考虑一般建议使用preparedStatement
        Statement statement = connection.createStatement();

        // executeQuery，执行查询语句
        String sql = "select * from people;";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println("id=" + resultSet.getObject("id"));
            System.out.println("name=" + resultSet.getObject("name"));
            System.out.println("age=" + resultSet.getObject("age"));
            System.out.println("address=" + resultSet.getObject("address"));
        }

        // 释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
