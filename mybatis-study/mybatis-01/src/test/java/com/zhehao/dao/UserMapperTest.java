package com.zhehao.dao;

import com.zhehao.pojo.User;
import com.zhehao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    @Test
    public void testGetUserList() {
        // 1.获取SqlSession的实例
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 2.获取UserMapper接口的实例类
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 3.使用UserDao实例类从数据库搜索
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        // 4.关闭SelSession
        sqlSession.close();
    }

    @Test
    public void testGetUserListById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserListById(1);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // MyBatis默认将每个方法调用封装在事务中，不会自动提交，需要手动调用sqlSession.commit()
        // 执行增删改操作后，如果没有显示调用commit()，事务将保持未提交状态
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.insertUser(new User(4, "Dave", "d416"));
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testUpdateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.updateUser(new User(4, "David", "d911"));
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void deleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.deleteUser(4);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testGetUserListByIdV2() {
        // 直接使用Map查询
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("mapId", 1);
        Map<String, Object> user = mapper.getUserListByIdV2(map);
        System.out.println(user.toString());

        sqlSession.close();
    }

    @Test
    public void testInsertUserV2() {
        // 直接使用Map插入
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("mapId", 5);
        map.put("mapName", "Edward");
        map.put("mapPwd", "e233");
        int res = mapper.insertUserV2(map);
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testGetUserByKeyword() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserByKeyword("o");
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }
}
