package com.jzy.snake;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: JWhale
 * Date: 2022/8/9
 * Time: 下午 12:39
 * Description:
 */
public class StartGames {
    public static void main(String[] args) {
        //1.绘制静态窗口 JFrame
        JFrame frame = new JFrame("jzy SnakeGame");
        //设置界面大小
        frame.setBounds(10,10,900,720);
        frame.setResizable(false);//窗口大小不可变
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭事件

        //2.面板 JPanel
        frame.add(new GamePanel());

        frame.setVisible(true);
    }
}
