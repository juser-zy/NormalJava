package com.jzy.pojo;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: JWhale
 * Date: 2022/8/29
 * Time: 下午 10:00
 * Description:
 */


@Data
public class Student {
    private int id;
    private String name;

    //学生关联一个老师
    private Teacher teacher;
}
