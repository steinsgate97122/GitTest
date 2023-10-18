package com.zhehao.dao;

import com.zhehao.pojo.Student;

import java.util.List;

public interface StudentMapper {

    // 从student表中获取所有学生信息 + 老师信息
    public List<Student> getAllStudents();

    public List<Student> getAllStudentsV2();

}
