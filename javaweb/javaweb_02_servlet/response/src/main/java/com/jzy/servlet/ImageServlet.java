package com.jzy.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: JWhale
 * Date: 2022/8/10
 * Time: 下午 3:43
 * Description:
 */
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //让浏览器3s自动刷新一次
        resp.setHeader("refresh","3");

        //在内存中创建一张图片
        BufferedImage image = new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0,0,80,20);
        //给图片写数据
        g.setColor(Color.BLUE);
        g.setFont(new Font(null,Font.BOLD,20));
        g.drawString(makeNum(),0,20);

        //告诉浏览器这个请求用图片打开
        resp.setContentType("image/jepg");
        resp.setDateHeader("Expires",0);
        resp.addHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");

        ImageIO.write(image, "jpeg", resp.getOutputStream());
    }
    private String makeNum(){
        Random random = new Random();
        String num = random.nextInt(9999999) + "";

        StringBuffer sb = new StringBuffer();
        for(int i = 0 ;i < 7-num.length();i++){
            sb.append("0");
        }
        num = sb.toString() + num;
        return num;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
