package com.jzy.servlet.user;

import com.jzy.pojo.User;
import com.jzy.service.user.UserService;
import com.jzy.service.user.UserServiceImpl;
import com.jzy.util.Constants;
import com.mysql.cj.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: JWhale
 * Date: 2022/8/13
 * Time: 下午 2:15
 * Description:
 */
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method != null && "savepwd".equals(method)) {
            updatePwd(req, resp);
        }

    }

    protected void updatePwd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从session获取用户id
        Object obj = req.getSession().getAttribute(Constants.USER_SESSION);
        //获取入参中的新密码
        String newPassWord = req.getParameter("newpassword");
        if (obj == null || StringUtils.isNullOrEmpty(newPassWord)) {
            req.setAttribute("message", "新密码不可为空~");
        } else {
            UserService userService = new UserServiceImpl();
            boolean flag = userService.updatePwd(((User) obj).getId(), newPassWord);
            if (flag) {
                req.setAttribute("message", "密码修改成功，请退出，使用新密码登录~");
                //修改成功，移除session
                req.getSession().removeAttribute(Constants.USER_SESSION);
            } else {
                req.setAttribute("message", "密码修改失败~");
            }
        }
        req.getRequestDispatcher("pwdmodify.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
