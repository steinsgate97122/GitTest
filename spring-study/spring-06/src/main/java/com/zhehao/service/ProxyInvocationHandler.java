package com.zhehao.service;

import lombok.Data;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Data
public class ProxyInvocationHandler implements InvocationHandler {
    // 被代理的对象，不指定具体对象，实现动态代理
    private Object target;

    // 返回一个代理对象，用Proxy.newProxyInstance()创建一个代理实例
    public Object getProxy() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }

    // 当代理对象的方法被调用时，会执行invoke()
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before " + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("after " + method.getName());
        return result;
    }
}
