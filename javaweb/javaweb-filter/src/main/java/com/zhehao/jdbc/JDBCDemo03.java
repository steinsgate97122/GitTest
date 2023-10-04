package com.zhehao.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDemo03 {
    @Test
    public void test() throws Exception {
        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "zhang97122";

        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);

            // 相当于数据库中start transaction开启事务，直到显性的commit()或rollback()，可以确保多个sql同时成功或失败
            connection.setAutoCommit(false);

            String sql1 = "update account set money = money - 100 where `name` = 'A'";
            connection.prepareStatement(sql1).executeUpdate();

            // 出现异常
            // int a = 1/0;

            String sql2 = "update account set money = money + 100 where `name` = 'B'";
            connection.prepareStatement(sql2).executeUpdate();

            // 手动提交事务
            connection.commit();
            System.out.println("success");
        } catch (Exception e) {
            try {
                // 捕获到异常时回滚事务
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            // 释放资源
            connection.close();
        }

    }
}
