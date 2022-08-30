package com.jzy.servlet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: JWhale
 * Date: 2022/8/10
 * Time: 下午 11:07
 * Description:
 */
public class CookieDemo03 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        //resp.setContentType("text/html;charset:utf-8");
        //resp.setHeader("Content-Type", "text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();

        //Cookie,服务器端从客户端获取
        Cookie[] cookies = req.getCookies();//这里返回的是数组，说明Cookie可能存在多个

        //判断Cookie是否存在
        if(cookies != null){
            //如果存在
            out.write("上一次访问的时间是：");
            for(Cookie cookie:cookies){
                if(cookie.getName().equals("name")){
                    out.write(URLDecoder.decode(cookie.getValue(),"utf-8"));
                }
            }
        }else{
            out.write("这是您第一次访问");
        }
        //添加 or 更新
        Cookie cookie = new Cookie("name", URLEncoder.encode("金", "UTF-8"));
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
