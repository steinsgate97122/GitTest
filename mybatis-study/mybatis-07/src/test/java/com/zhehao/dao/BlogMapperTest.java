package com.zhehao.dao;

import com.zhehao.pojo.Blog;
import com.zhehao.utils.IDUtils;
import com.zhehao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlogMapperTest {
    @Test
    public void testGetId() {
        System.out.println(IDUtils.getId());
    }

    @Test
    public void testInsertBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDUtils.getId());
        blog.setAuthor("zhehao");
        blog.setTitle("Title-01");
        blog.setCreateTime(new Date());
        blog.setViews(1000);
        mapper.insertBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setAuthor("haohao");
        blog.setTitle("Title-02");
        blog.setViews(9999);
        mapper.insertBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setAuthor("zhehao");
        blog.setTitle("Title-03");
        blog.setViews(5000);
        mapper.insertBlog(blog);

        sqlSession.close();
    }

    @Test
    public void testGetBlogListIf() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, String> blogMap = new HashMap<>();
        List<Blog> blogListIf = mapper.getBlogListIf(blogMap);
        System.out.println(Arrays.toString(blogListIf.toArray()));

        blogMap.put("views", "5000");
        blogListIf = mapper.getBlogListIf(blogMap);
        System.out.println(Arrays.toString(blogListIf.toArray()));

        blogMap.put("title", "Title-03");
        blogListIf = mapper.getBlogListIf(blogMap);
        System.out.println(Arrays.toString(blogListIf.toArray()));

        sqlSession.close();
    }

    @Test
    public void testGetBlogListChoose() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, String> blogMap = new HashMap<>();
        List<Blog> blogList = mapper.getBlogListChoose(blogMap);
        System.out.println(Arrays.toString(blogList.toArray()));

        blogMap.put("title", "Title-03");
        blogList = mapper.getBlogListChoose(blogMap);
        System.out.println(Arrays.toString(blogList.toArray()));

        blogMap.clear();
        blogMap.put("views", "5000");
        blogList = mapper.getBlogListChoose(blogMap);
        System.out.println(Arrays.toString(blogList.toArray()));

        sqlSession.close();
    }

    @Test
    public void testUpdateBlogByTitle() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, Object> blogMap = new HashMap<>();
        blogMap.put("createTime", new Date());
//        blogMap.put("views", 2000);
        blogMap.put("title", "Title-01");
        mapper.updateBlogByTitle(blogMap);

        sqlSession.close();
    }

    @Test
    public void testGetBlogListForEach() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, Object> blogMap = new HashMap<>();
        List<String> titleList = Arrays.asList("Title-01", "Title-02");
        blogMap.put("titleList", titleList);
        List<Blog> blogList = mapper.getBlogListForEach(blogMap);
        System.out.println(Arrays.toString(blogList.toArray()));

        sqlSession.close();
    }
}
