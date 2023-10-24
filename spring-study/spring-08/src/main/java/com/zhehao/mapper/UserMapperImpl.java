package com.zhehao.mapper;

import com.zhehao.pojo.User;
import lombok.Data;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

/*
在Mybatis项目中其实不需要这个实现类，直接sqlSession.getMapper(UserMapper.class)即可
但Spring项目需要一个UserMapper接口的实现类来创建bean，将UserMapperImpl注入Spring容器，这种方式更符合Spring的管理流程
 */
@Data
public class UserMapperImpl implements UserMapper {
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<User> getUserList() {
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        return mapper.getUserList();
    }

    @Override
    public int insertUser(User user) {
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        return mapper.insertUser(user);
    }

    @Override
    public void deleteUser(int id) {
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        mapper.deleteUser(id);
    }

    @Override
    public void operateUser(User user) {

    }
}
