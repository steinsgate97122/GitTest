package com.zhehao.dao;

import com.zhehao.pojo.Student;
import com.zhehao.pojo.Teacher;
import com.zhehao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class StudentMapperTest {
    @Test
    public void testGetAllStudents() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.getAllStudents();
        for (Student student : students) {
            System.out.println(student);
        }

        sqlSession.close();
    }

    @Test
    public void testGetAllStudentsV2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.getAllStudentsV2();
        for (Student student : students) {
            System.out.println(student);
        }

        sqlSession.close();
    }
}
