package com.jzy.servlet;

import com.jzy.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: JWhale
 * Date: 2022/8/11
 * Time: 上午 8:33
 * Description:
 */
public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码问题
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        //得到session
        HttpSession session = req.getSession();
        //给session存东西
        //session.setAttribute("name","金正");
        session.setAttribute("name",new Person("金正",64));

        //获取sessionID
        String sessionId = session.getId();

        //判断session是否为新
        if(session.isNew()){
            resp.getWriter().write("session创建成功，ID为" + sessionId);
        }else{
            resp.getWriter().write("session已经存在，ID为"+sessionId);
        }

        //session创建的时候做了什么事情
        //Cookie cookie = new Cookie("JSESSIONID",sessionId);
        //resp.addCookie(cookie);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
