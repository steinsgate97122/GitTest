package com.zhehao.mapper;

import com.zhehao.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/*
继承SqlSessionDaoSupport后，不需要自己定义SqlSessionTemplate对象，已在SqlSessionDaoSupport定义
注入时传参SqlSessionFactory，即可获得sqlSession对象，更加简便
 */
public class UserMapperImplV2 extends SqlSessionDaoSupport implements UserMapper {
    @Override
    public List<User> getUserList() {
        return getSqlSession().getMapper(UserMapper.class).getUserList();
    }

    @Override
    public int insertUser(User user) {
        return getSqlSession().getMapper(UserMapper.class).insertUser(user);
    }

    @Override
    public void deleteUser(int id) {
        getSqlSession().getMapper(UserMapper.class).deleteUser(id);
    }

    // 该方法被事务管理，见spring-dao.xml
    public void operateUser(User user) {
        insertUser(user);
        deleteUser(user.getId());
    }
}
