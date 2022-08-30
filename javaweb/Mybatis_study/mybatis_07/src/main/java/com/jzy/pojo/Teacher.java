package com.jzy.pojo;

import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: JWhale
 * Date: 2022/8/29
 * Time: 下午 10:01
 * Description:
 */

@Data
public class Teacher {
    private int id;
    private String name;
    private List<Student> students;
}
