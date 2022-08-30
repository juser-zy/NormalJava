package com.jzy.dao;

import com.jzy.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询全部用户
    List<User> getUserList();

    //根据ID查询
    User getUserById(int id);

    //insert
    int addUser(User user);

    //万能的map
    int addUser2(Map<String,Object> map);

    int updateUser(User user);

    int deleteUser(int id);
}
