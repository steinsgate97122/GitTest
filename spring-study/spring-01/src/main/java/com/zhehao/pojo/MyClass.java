package com.zhehao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
// 未定义无参构造，配置文件中需要使用<constructor-arg>对Bean赋值
public class MyClass {
    private int id;
    private Hello hello;
}
