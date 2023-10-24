package com.zhehao.service;

import lombok.Data;

@Data
public class UserServiceProxy implements UserService {

    // 代理了一个UserService对象，使用被代理对象的saveUser()，并加入了一些额外逻辑
    private UserService userService;

    @Override
    public void saveUser() {
        System.out.println("before save user");
        userService.saveUser(); // 调用真正的业务逻辑，代理类可以在不改变原有业务逻辑的基础上，加入新的功能
        System.out.println("after save user");
    }
}
