package com.zhehao.dao;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

// 数据库公共类，封装配置文件加载，获取connection等
public class BaseDao {
    private static final String driver;
    private static final String url;
    private static final String username;
    private static final String password;

    static {
        // 类加载时执行静态代码块，加载配置文件
        InputStream inputStream = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");

        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
    }

    // 获取数据库连接对象
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    /**
     * 数据库查询方法，返回ResultSet
     * 将preparedStatement作为参数传入，是为了后续方便统一关闭，也可以直接在改方法内关闭preparedStatement
     */
    public static ResultSet executeQuery(Connection connection, PreparedStatement preparedStatement, String sql, Object[] params) {
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i + 1, params[i]);
                }
            }
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultSet;
    }

    /**
     * 数据库更新方法，返回int
     */
    public static int executeUpdate(Connection connection, PreparedStatement preparedStatement, String sql, Object[] params) {
        int res = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            res = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    /**
     * 释放资源
     */
    public static boolean closeResources(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        boolean flag = true;
        if (resultSet != null) {
            try {
                resultSet.close();
                resultSet = null;
            } catch (SQLException e) {
                e.printStackTrace();
                flag = false;
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
                preparedStatement = null;
            } catch (SQLException e) {
                e.printStackTrace();
                flag = false;
            }
        }
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
                flag = false;
            }
        }
        return flag;
    }

/*
    @Test
    public void test() throws SQLException {
        Connection connection = getConnection();
        String sql = "select * from people";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = executeQuery(connection, preparedStatement, sql, null);
        while (resultSet.next()) {
            System.out.println("id=" + resultSet.getObject("id"));
            System.out.println("name=" + resultSet.getObject("name"));
            System.out.println("age=" + resultSet.getObject("age"));
            System.out.println("address=" + resultSet.getObject("address"));
        }
        closeResources(connection,preparedStatement,resultSet);
    }
*/
}
