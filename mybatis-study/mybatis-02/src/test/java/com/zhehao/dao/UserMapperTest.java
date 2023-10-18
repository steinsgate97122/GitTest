package com.zhehao.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.zhehao.pojo.User;
import com.zhehao.utils.MybatisUtils;

import java.util.List;

public class UserMapperTest {
    @Test
    public void testGetUserList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
