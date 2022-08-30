import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created with IntelliJ IDEA.
 * User: JWhale
 * Date: 2022/8/8
 * Time: 23:09
 * Description:
 */
public class jdbc_demo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //推荐这种写法加载驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2.用户信息和URL
        // useSSL=true可能会报错
        // jdbc:mysql://主机地址：端口号/数据库名?参数1&参数2&参数3
        String url = "jdbc:mysql://localhost:3306/jdbcstudy?" +
                "useUnicode=true&characterEncoding=utf8&useSSL=false";
        String userName = "root";
        String passWord = "123456";


        //3.连接成功，数据库对象 Connection代表数据库
        Connection connection = DriverManager.getConnection(url,userName,passWord);


        //4.执行SQl的对象 Statement 执行的sql对象
        Statement statement = connection.createStatement();


        //5.执行SQL的对象 去 执行SQL ，可能存在结果，查看返回的结果
        String sql = "SELECT * FROM users";
        //statement.executeQuery();//执行查询 返回ResultSet
        //statement.executeUpdate();//新增，删除，修改，都用这个，返回受影响的行数
        //statement.execute();//执行任何SQL

        //返回的结果集 结果集中封装了我们全部的查询的结果
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println("id = " + resultSet.getObject("id"));
            System.out.println("name = " + resultSet.getObject("name"));
            System.out.println("password = " + resultSet.getObject("password"));
            System.out.println("email = " + resultSet.getObject("email"));
            System.out.println("birthday = " + resultSet.getObject("birthday"));
            System.out.println("============================================");
        }


        //6.释放连接
        resultSet.close();
        statement.close();
        connection.close();

    }
}
