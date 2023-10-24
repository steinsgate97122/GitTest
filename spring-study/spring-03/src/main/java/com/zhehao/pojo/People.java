package com.zhehao.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Data
public class People {
    private String name;

    /*
        @Autowired根据Class类自动装配Bean，如果有多个匹配的Bean，可以结合@Qualifier指定Bean的名称
        下面的例子中，将名称为cat的Bean自动注入到class为People的Bean中
        java标准库中有类似的注解@Resource，在Spring框架中不建议使用
     */
    @Autowired
    @Qualifier("cat")
    private Cat cat;

    @Autowired
    private Dog dog;
}
