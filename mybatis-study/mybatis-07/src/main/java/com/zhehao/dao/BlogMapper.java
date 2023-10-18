package com.zhehao.dao;

import com.zhehao.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    public void insertBlog(Blog blog);

    public List<Blog> getBlogListIf(Map<String, String> map);

    public List<Blog> getBlogListChoose(Map<String, String> map);

    public int updateBlogByTitle(Map<String, Object> map);

    public List<Blog> getBlogListForEach(Map<String, Object> map);

}
