package com.zhehao.dao;

import com.zhehao.pojo.Teacher;
import com.zhehao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TeacherMapperTest {
    @Test
    public void testGetTeacher() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);

        sqlSession.close();
    }

    @Test
    public void testGetTeacherV2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacherV2(1);
        System.out.println(teacher);

        sqlSession.close();
    }
}
