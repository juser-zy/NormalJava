package com.jzy.servlet.user;

import com.jzy.pojo.User;
import com.jzy.service.user.UserServiceImpl;
import com.jzy.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: JWhale
 * Date: 2022/8/13
 * Time: 下午 12:11
 * Description:
 */
public class LoginServlet extends HttpServlet {

    //Servlet:调用业务层代码
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginServlet--start");
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");

        //和数据库密码进行比对，调用业务层
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.login(userCode,userPassword);
        if(user!=null && user.getUserPassword().equals(userPassword)){
            //将用户信息放入session中
            req.getSession().setAttribute(Constants.USER_SESSION,user);
            //跳转到内部主页
            resp.sendRedirect("jsp/frame.jsp");
        }else {
            req.setAttribute("error","用户名或者密码不正确");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
