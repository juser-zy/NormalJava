package com.jzy.dao.user;

import com.jzy.dao.BaseDao;
import com.jzy.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: JWhale
 * Date: 2022/8/13
 * Time: 上午 11:39
 * Description:
 */
public class UserDaoImpl implements UserDao {

    public User getLogin(String userCode, Connection connection) throws SQLException {

        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;

        if (connection != null) {
            String sql = "select * from smbms_user where userCode=?";
            Object[] params = {userCode};
            rs = BaseDao.execute(connection, sql, params, rs, pstm);

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setUserRole(rs.getInt("userRole"));
                user.setCreatedBy(rs.getInt("createdBy"));
                user.setModifyBy(rs.getInt("modifyBy"));
                user.setCreationDate(rs.getTimestamp("creationDate"));
                user.setModifyDate(rs.getTimestamp("modifyDate"));
            }
            BaseDao.closeResourse(connection, pstm, rs);

        }
        return user;
    }

    public int updatePwd(Connection connection, int id, String password) throws SQLException {
        int updateCount = 0;
        if(connection != null){
            PreparedStatement pstm = null;
            String sql = "update smbms_user set userPassword = ? where id = ?";
            Object[] params = {password,id};
            updateCount = BaseDao.execute(connection,sql,params,pstm);
            BaseDao.closeResourse(connection,pstm,null);
        }
        return updateCount;
    }
}
