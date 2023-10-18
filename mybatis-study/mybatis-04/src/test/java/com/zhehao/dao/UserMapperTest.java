package com.zhehao.dao;

import com.zhehao.pojo.User;
import com.zhehao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

public class UserMapperTest {

    /**
     * DEBUG（调试级别），用于输出详细的调试信息，如方法调用、变量值、循环迭代等详细信息
     * INFO（信息级别）， 用于输出程序运行过程中的一般性信息，如应用程序启动、配置信息
     * ERROR（错误级别），用于输出错误信息，如数据库连接失败、文件无法读取、业务逻辑错误
     * 实际应用中需要选择适当的日志级别
     */
    static Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void testGetUserList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserListById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testInsertUser() {
        // 开启了autoCommit
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.insertUser(new User(6, "Fernando", "f14"));

        sqlSession.close();
    }

    @Test
    public void testUpdateUser() {
        // 开启了autoCommit
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(6, "Fernando", "f1414"));

        sqlSession.close();
    }

    @Test
    public void testDeleteUser() {
        // 开启了autoCommit
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(6);

        sqlSession.close();
    }

}
