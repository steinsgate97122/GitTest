package com.zhehao.service.user;

import com.zhehao.dao.user.UserDaoImpl;
import com.zhehao.pojo.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class UserServiceImpl implements UserService {
    // 业务层
    private final UserDaoImpl userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    public User login(String userCode, String password) {
        User userRes = null;
        ArrayList<User> loginUser = userDao.getLoginUser(userCode);
        for (User user : loginUser) {
            if (user.getUserPassword().equals(password)) {
                // 密码正确时，登录成功
                userRes = user;
                break;
            }
        }
        return userRes;
    }

    public boolean changePassword(int id, String password) {
        boolean flag = false;
        int i = userDao.changePassword(id, password);
        if (i > 0) {
            // 更新成功
            flag = true;
        }
        return flag;
    }

    public int getUserCount(String userName, int userRole) {
        int count = userDao.getUserCount(userName, userRole);
        return count;
    }

    public ArrayList<User> getUserList(String userName, int userRole, int currentNo, int pageSize) {
        ArrayList<User> userList = userDao.getUserList(userName, userRole, currentNo, pageSize);
        return userList;
    }

    public boolean addUser(User user) {
        int insertRowNum = userDao.addUser(user);
        return insertRowNum > 0;
    }

    @Test
    public void testLogin() {
        UserServiceImpl userService = new UserServiceImpl();
        // 密码正确
        User admin1 = userService.login("admin", "12345678");
        Assert.assertNull(admin1);

        // 密码错误
        User admin2 = userService.login("admin", "1234567");
        Assert.assertNotNull(admin2);
    }

    @Test
    public void testUserCount() {
        UserServiceImpl userService = new UserServiceImpl();

        int count1 = userService.getUserCount("12", 5);
        System.out.println(count1);

        int count2 = userService.getUserCount("12", 0);
        System.out.println(count2);

        int count3 = userService.getUserCount(null, 3);
        System.out.println(count3);
    }

    @Test
    public void testUserList() {
        UserServiceImpl userService = new UserServiceImpl();

        ArrayList<User> userList1 = userService.getUserList(null, 0, 1, 5);
        System.out.println(Arrays.toString(userList1.toArray()));

        ArrayList<User> userList2 = userService.getUserList(null, 0, 10, 5);
        System.out.println(Arrays.toString(userList2.toArray()));
    }
}
