package com.jzy.dao;

import com.jzy.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    List<Blog> queryBlogIF(Map map);

    int addBlog(Blog blog);
}
