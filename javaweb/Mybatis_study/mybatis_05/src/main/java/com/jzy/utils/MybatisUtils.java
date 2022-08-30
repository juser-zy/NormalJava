package com.jzy.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: JWhale
 * Date: 2022/8/29
 * Time: 下午 1:03
 * Description:
 */
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory = null;
    static {
        InputStream inputStream = null;
        {
            try {
                String resource = "mybatis-config.xml";
                inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

}
