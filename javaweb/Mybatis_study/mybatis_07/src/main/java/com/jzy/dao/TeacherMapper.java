package com.jzy.dao;

import com.jzy.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {
    List<Teacher> getTeacher();

    //获取指定老师下的所有学生以及老师的信息
    Teacher getTeacherStudent(@Param("tid")int id);
}
