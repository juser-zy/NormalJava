package com.jzy.pojo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: JWhale
 * Date: 2022/8/30
 * Time: 上午 10:35
 * Description:
 */
@Data
public class Blog {
    private String id;
    private String title;
    private String author;
    private Date createTime;
    private int views;
}

