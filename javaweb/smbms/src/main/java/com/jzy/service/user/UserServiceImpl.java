package com.jzy.service.user;

import com.jzy.dao.BaseDao;
import com.jzy.dao.user.UserDao;
import com.jzy.dao.user.UserDaoImpl;
import com.jzy.pojo.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: JWhale
 * Date: 2022/8/13
 * Time: 上午 11:52
 * Description:
 */
public class UserServiceImpl implements UserService{

    //引入Dao层
    private UserDao userDao;
    public UserServiceImpl(){
        userDao = new UserDaoImpl();
    }


    public User login(String userCode, String password) {
        Connection connection = null;
        User user = null;
        try {
            connection = BaseDao.getConnection();
            //通过业务层调用具体的数据库操作
            user = userDao.getLogin(userCode,connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            BaseDao.closeResourse(connection,null,null);
        }
        return user;
    }


    public boolean updatePwd(int id, String password) {
        Connection connection = null;
        boolean updateFlag =false;
        try {
            connection = BaseDao.getConnection();
            int updateCount = userDao.updatePwd(connection,id,password);
            if(updateCount > 0){
                updateFlag = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            BaseDao.closeResourse(connection,null,null);
        }
        return updateFlag;
    }

    @Test
    public void test(){
        UserServiceImpl userService = new UserServiceImpl();
        User admin = userService.login("admin","111111");
        System.out.println(admin.getUserPassword());
    }
}
