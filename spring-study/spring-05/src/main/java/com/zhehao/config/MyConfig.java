package com.zhehao.config;

import com.zhehao.pojo.Address;
import com.zhehao.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
@Configuration表明当前类是一个配置类，在这个类中定义所有需要在Spring容器中创建的Bean，替代原先的xml配置文件
下面的例子中，Bean的创建由user()和address()负责，并使用@Bean标记
 */
@Configuration
public class MyConfig {
    @Bean
    public User user() {
        return new User();
    }

    @Bean
    public Address address() {
        return new Address();
    }
}
