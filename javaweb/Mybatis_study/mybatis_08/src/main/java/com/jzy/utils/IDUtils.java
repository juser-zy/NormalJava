package com.jzy.utils;

import org.testng.annotations.Test;

import java.lang.annotation.Target;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: JWhale
 * Date: 2022/8/30
 * Time: 上午 10:46
 * Description:
 */
public class IDUtils {

    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    @Test
    public void test(){
        System.out.println(IDUtils.getId());
    }
}
