package com.zhehao.dao;

import com.zhehao.pojo.Teacher;

public interface TeacherMapper {
    // 从student表中获取所有学生信息 + 老师信息
    public Teacher getTeacher(int id);

    public Teacher getTeacherV2(int id);
}
