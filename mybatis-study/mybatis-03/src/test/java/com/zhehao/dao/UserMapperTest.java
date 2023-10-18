package com.zhehao.dao;

import com.zhehao.pojo.User;
import com.zhehao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        logger.info("-----进入testGetUserList-----");
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserListById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testLog4j() {
        logger.debug("debug");
        logger.info("info");
        logger.error("error");
    }

    @Test
    public void testGetUserListByPage() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("offset", 1);
        map.put("pageSize", 2);
        // 期望返回第2，3条数据
        List<User> userList = mapper.getUserListByPage(map);
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }
}
