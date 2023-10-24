package com.zhehao.mapper;

import com.zhehao.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    public List<User> getUserList();

    public int insertUser(User user);

    public void deleteUser(int id);

    public void operateUser(User user);
}
