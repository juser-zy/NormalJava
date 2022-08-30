package com.jzy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: JWhale
 * Date: 2022/8/10
 * Time: 下午 2:52
 * Description:
 */
public class servletdemo_05 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        InputStream is = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
        InputStream is = this.getServletContext().getResourceAsStream("/WEB-INF/classes/com/jzy/servlet/db.properties");
        Properties pro = new Properties();
        pro.load(is);
        String user = pro.getProperty("username");
        String pwd = pro.getProperty("password");
        resp.getWriter().print("username:" + user + '\n' + "pwd:" + pwd);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
