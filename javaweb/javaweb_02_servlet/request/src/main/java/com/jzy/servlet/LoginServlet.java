package com.jzy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: JWhale
 * Date: 2022/8/10
 * Time: 下午 8:37
 * Description:
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //后台接收中文乱码问题
        req.setCharacterEncoding("utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("pwd");
        String[] hobbies = req.getParameterValues("hobbies");

        System.out.println("======================");
        System.out.println(username);
        System.out.println(password);

        System.out.println(Arrays.toString(hobbies));
        System.out.println("======================");
        //通过请求转发
        //这里的/代表当天的web应用

        req.getRequestDispatcher("/success.jsp").forward(req, resp);
        //这样子也行
        //resp.sendRedirect("/request_war/success.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
