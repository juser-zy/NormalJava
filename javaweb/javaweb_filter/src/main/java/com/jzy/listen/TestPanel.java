package com.jzy.listen;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created with IntelliJ IDEA.
 * User: JWhale
 * Date: 2022/8/12
 * Time: 下午 3:49
 * Description:
 */
public class TestPanel {
    public static void main(String[] args) {
        Frame frame = new Frame("测试");
        Panel panel = new Panel();

        frame.setLayout(null);
        frame.setBounds(300, 300, 500, 500);
        frame.setBackground(new Color(0, 0, 255));

        panel.setBounds(50, 50, 300, 300);
        panel.setBackground(new Color(255, 0, 0));

        frame.add(panel);
        frame.setVisible(true);

        //添加一个窗口关闭的监听事件
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }
}
