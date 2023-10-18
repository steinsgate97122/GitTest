package com.zhehao.dao;

import com.zhehao.pojo.User;

import java.util.List;
import java.util.Map;
import java.util.Objects;

// 不需要写UserMapperImpl，用配置文件UserMapper.xml代替
public interface UserMapper {
    // 根据id查询用户
    User getUserListById(int id);

    // 分页查询
    List<User> getUserListByPage(Map<String, Object> map);
}
