package com.zhehao.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {

    // SqlSessionFactory在应用运行期间一直存在，不需要重新创建
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            // SqlSessionFactoryBuilder仅用于创建SqlSessionFactory，创建完毕后不再需要，作为局部变量即可
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 通过SqlSessionFactory获得SqlSession的实例，SqlSession提供了在数据库执行SQL命令所需的所有方法
    public static SqlSession getSqlSession() {
        // SqlSession线程不安全，用完之后关闭资源
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }

}
