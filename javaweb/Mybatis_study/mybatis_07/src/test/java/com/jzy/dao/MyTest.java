package com.jzy.dao;

import com.jzy.pojo.Student;
import com.jzy.pojo.Teacher;
import com.jzy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: JWhale
 * Date: 2022/8/29
 * Time: 下午 10:12
 * Description:
 */
public class MyTest {
    @Test
    public void getTeacher(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.getTeacher();
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
        sqlSession.close();
    }

    @Test
    public void getTeacherStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacherStudent = mapper.getTeacherStudent(1);
        System.out.println(teacherStudent);
        sqlSession.close();
    }

}
