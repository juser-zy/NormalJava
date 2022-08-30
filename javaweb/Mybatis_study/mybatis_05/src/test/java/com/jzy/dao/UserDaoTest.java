package com.jzy.dao;

import com.jzy.pojo.User;
import com.jzy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: JWhale
 * Date: 2022/8/29
 * Time: 下午 1:12
 * Description:
 */
public class UserDaoTest {

    static Logger logger = Logger.getLogger(UserDaoTest.class);


    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        List<User> users = mapper.getUser();
//        for (User user : users) {
//            logger.info(user);
//        }
        User userById = mapper.getUserById(1);
        System.out.println(userById);
        sqlSession.close();
    }

}
