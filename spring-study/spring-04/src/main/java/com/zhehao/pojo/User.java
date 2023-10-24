package com.zhehao.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
/*
@Component等价于在配置文件中<bean id="user" class="com.zhehao.pojo.User"/>
@Component有几个衍生注解功能相同，只是语义上存在区别：
    1、@Repository，用于持久层类，Spring会将它识别为一个DAO组件，处理数据库操作
    2、@Service，用于业务逻辑层类，Spring会将它识别为一个Service组件
    3、@Controller，用于Web层类，Spring会将它识别为一个Controller组件，处理用户请求
还可以配合@Scope注解指定作用域
 */
@Component
@Scope("singleton")
public class User {
    /*
    @Value等价于在配置文件中<property name="name" value="zhehao">
    当涉及到复杂类型的属性时，@Value无法注入，可以使用xml配置，或者使用Java配置类（见spring-05）
     */
    @Value("zhehao")
    private String name;

    @Autowired
    private Address address;

    @Value("Murder on the Orient Express,Death on the Nile")
    private String[] books;

    @Value("read,game")
    private List<String> hobbies;
}
