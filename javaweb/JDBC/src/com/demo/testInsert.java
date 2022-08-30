package com.demo;
import com.demo.utils.JdbcUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created with IntelliJ IDEA.
 * User: JWhale
 * Date: 2022/8/9
 * Time: 10:52
 * Description:
 */
public class testInsert {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            String sql = "INSERT INTO users" +
                    "(`id`,`name`,`password`,`email`,`birthday`) " +
                    "VALUES (5,'jzy','123456','1669903129@qq.com','1999-10-27');";
            int i = st.executeUpdate(sql);
            if(i > 0){
                System.out.println("insert success");
            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn,st,rs);
        }
    }
}
