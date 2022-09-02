import com.jzy.dao.UserMapper;
import com.jzy.pojo.User;
import com.jzy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: JWhale
 * Date: 2022/9/2
 * Time: 下午 5:27
 * Description:
 */
public class MyTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
