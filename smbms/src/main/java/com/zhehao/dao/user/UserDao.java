package com.zhehao.dao.user;

import com.zhehao.pojo.User;

import java.sql.Connection;
import java.util.ArrayList;

public interface UserDao {

    // 根据userCode，获取该userCode对应的所有用户集合
    public ArrayList<User> getLoginUser(String userCode);

    // 修改密码
    public int changePassword(int id, String password);

    // 获取用户总数，userName和userRole为筛选条件，支持根据userName模糊搜索，支持根据userRole搜索
    public int getUserCount(String userName, int userRole);

    // 获取用户列表，带上筛选项，分页
    public ArrayList<User> getUserList(String userName, int userRole, int currentNo, int pageSize);

    // 新增用户
    public int addUser(User user);
}
