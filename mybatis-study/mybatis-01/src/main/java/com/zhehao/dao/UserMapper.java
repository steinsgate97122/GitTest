package com.zhehao.dao;

import com.zhehao.pojo.User;

import java.util.List;
import java.util.Map;

// 不需要写UserMapperImpl，用配置文件UserMapper.xml代替
public interface UserMapper {
    // 查询全部用户
    List<User> getUserList();

    // 根据id查询用户
    User getUserListById(int id);

    // 插入用户
    int insertUser(User user);

    // 更新用户
    int updateUser(User user);

    // 删除用户
    int deleteUser(int id);

    // 根据id查询用户，传参Map
    Map<String, Object> getUserListByIdV2(Map<String, Object> map);

    // 插入用户，传参Map
    int insertUserV2(Map<String, Object> map);

    // 模糊查询用户
    List<User> getUserByKeyword(String keyword);
}