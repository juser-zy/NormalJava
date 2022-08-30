package com.jzy.pojo;

import org.apache.ibatis.type.Alias;

/**
 * Created with IntelliJ IDEA.
 * User: JWhale
 * Date: 2022/8/29
 * Time: 下午 1:07
 * Description:
 */
@Alias("hello")
public class User {
    private int id;
    private String name;
    private String pwd;

    public User(int id) {
        this.id = id;
    }

    public User() {
    }

    public User(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
