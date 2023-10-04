package com.zhehao.service.user;

import com.zhehao.pojo.User;

import java.util.ArrayList;

public interface UserService {
    // 根据userCode和password判断用户是否登录成功
    public User login(String userCode, String password);

    // 修改密码
    public boolean changePassword(int id, String password);

    // 获取用户总数
    public int getUserCount(String userName, int userRole);

    // 获取用户列表
    public ArrayList<User> getUserList(String userName, int userRole, int currentNo, int pageSize);

    // 新增用户
    public boolean addUser(User user);
}
