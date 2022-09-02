package com.jzy.dao;

import com.jzy.pojo.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: JWhale
 * Date: 2022/9/2
 * Time: 下午 5:24
 * Description:
 */
public interface UserMapper {
    //查询所有User
    List<User> getUserList();
}
