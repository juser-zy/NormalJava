package com.jzy.dao.user;

import com.jzy.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: JWhale
 * Date: 2022/8/13
 * Time: 上午 11:37
 * Description:
 */
public interface UserDao {
    //得到要登陆的用户
    public User getLogin(String userCode, Connection connection) throws SQLException;

    /**
     * 修改密码
     *
     * @param connection
     * @param id
     * @param password
     * @return
     * @throws SQLException
     */

    int updatePwd(Connection connection, int id, String password) throws SQLException;

}
