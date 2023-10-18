package com.zhehao.utils;

import java.util.UUID;

public class IDUtils {

    // 生成随机id
    public static String getId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
