package com.jzy.dao;

import com.jzy.pojo.User;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface UserMapper {
    List<User> getUserList();

    List<User> getUserByLimit(Map<String, Integer> map);

    User getUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
