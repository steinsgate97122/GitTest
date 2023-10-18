package com.zhehao.dao;

import com.zhehao.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    // 注解适用于简单的、固定的SQL操作，代码更加紧凑易读，需要在mybatis-config.xml中注册class
    // 数据库列名与属性名不一致时，可以用@Result或@Results注解完成映射
    @Result(column = "pwd", property = "password")
    @Select("select * from mybatis.`user` where `id` = #{uid}")
    User getUserListById(@Param("uid") int id);

    @Insert("insert into mybatis.`user`(`id`, `name`, `pwd`) values (#{id}, #{name}, #{password})")
    int insertUser(User user);

    @Update("update mybatis.`user` set pwd = #{password} where id = #{id}")
    // 更新用户
    int updateUser(User user);

    @Delete("delete from mybatis.`user` where id = #{id}")
    // 删除用户
    int deleteUser(int id);
}
