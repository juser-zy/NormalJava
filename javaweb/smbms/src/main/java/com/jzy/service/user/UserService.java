package com.jzy.service.user;

import com.jzy.pojo.User;

public interface UserService {
    /**
     * 登录
     * @param userCode
     * @param password
     * @return
     */
    public User login(String userCode, String password);

    /**
     * 修改密码
     *
     * @param id
     * @param password
     * @return
     */
    boolean updatePwd(int id, String password);
}
