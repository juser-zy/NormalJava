package com.jzy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: JWhale
 * Date: 2022/8/29
 * Time: 下午 1:07
 * Description:
 */

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String password;


}
