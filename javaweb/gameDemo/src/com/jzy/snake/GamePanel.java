package com.jzy.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Time;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: JWhale
 * Date: 2022/8/9
 * Time: 下午 12:46
 * Description:
 */
public class GamePanel extends JPanel implements KeyListener,ActionListener {

    int length;
    int[] snakeX = new int[600];
    int[] snakeY = new int[500];
    String fx;

    boolean isStart = false;

    Timer timer = new Timer(100, this);

    int foodx;
    int foody;

    boolean isFail = false;
    int score;

    Random random = new Random();

    public GamePanel(){
        init();
        //获取键盘的监听事件
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();
    }

    //初始化
    public void init(){
        length = 3;
        snakeX[0] = 100;snakeY[0] = 100;//头部坐标
        snakeX[1] = 75;snakeY[1] = 100;//第一节身体
        snakeX[2] = 50;snakeY[2] = 100;//第二节身体
        fx = "R";
        foodx = 25 + 25*random.nextInt(34);
        foody = 75 + 25*random.nextInt(24);

        score = 0; //初始化游戏分数
    }

    //画板
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);//清屏
        this.setBackground(Color.WHITE);

        //绘制头部广告栏
        Data.header.paintIcon(this,g,25,11);

        //绘制游戏区域
        g.fillRect(25,75,850,600);


        //一条静态小蛇
        if(fx.equals("R")){
            Data.right.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if(fx.equals("L")){
            Data.left.paintIcon(this,g,snakeX[0],snakeY[0]);
        } else if (fx.equals("U")) {
            Data.up.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if (fx.equals("D")) {
            Data.down.paintIcon(this,g,snakeX[0],snakeY[0]);
        }

        for (int i = 1 ; i < length ;i++){
            Data.body.paintIcon(this,g,snakeX[i],snakeY[i]);
        }

        Data.food.paintIcon(this,g,foodx,foody);
        g.setColor(Color.white);
        g.setFont(new Font("微软雅黑",Font.BOLD,18));
        g.drawString("长度 " + length,750,35);
        g.drawString("分数 " + score,750,50);

        //游戏提示：是否开始
        if(isStart == false){
            g.setColor(Color.WHITE);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("按下空格开始游戏",300,300);
        }

        if(isFail == true){
            g.setColor(Color.RED);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("按下空格重新开始",300,300);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        //键盘按下去，弹起
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //键盘按下，未释放
        //获取按下的键盘
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_SPACE){
            if (isFail){
                isFail = false;
                init();
            } else{
                isStart = !isStart;
            }
            repaint();//刷新界面
        }
        if(keyCode == KeyEvent.VK_LEFT){
            fx = "L";
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            fx = "R";
        }else if (keyCode == KeyEvent.VK_UP) {
            fx = "U";
        }else if (keyCode == KeyEvent.VK_DOWN) {
            fx = "D";
        }
    }

    //定时器，监听事件
    @Override
    public void actionPerformed(ActionEvent e) {
        if(isStart && isFail==false){
            //右移
            for(int i = length - 1 ; i > 0 ;--i){
                snakeX[i] = snakeX[i-1];
                snakeY[i] = snakeY[i-1];
            }

            //通过控制方向让头部移动
            if(fx.equals("R")){
                snakeX[0] = snakeX[0] + 25;//头部移动
                if(snakeX[0] > 850){
                    snakeX[0] = 25;
                }//边界判断
            }else if (fx.equals("L")) {
                snakeX[0] = snakeX[0] - 25;
                if(snakeX[0] < 25){
                    snakeX[0] = 850;
                }//边界判断
            }else if (fx.equals("U")) {
                snakeY[0] = snakeY[0] - 25;
                if(snakeY[0] < 75){
                    snakeY[0] = 650;
                }//边界判断
            }else if (fx.equals("D")) {
                snakeY[0] = snakeY[0] + 25;
                if(snakeY[0] > 650){
                    snakeY[0] = 75;
                }//边界判断
            }

            if(snakeX[0]==foodx && snakeY[0] == foody){
                length++;
                score = score + 10;
                foodx = 25 + 25*random.nextInt(34);
                foody = 75 + 25*random.nextInt(24);
            }

            //结束判断
            for(int i = 1 ; i < length ;i++){
                if(snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]){
                    isFail = true;
                }
            }
            repaint();
        }
        timer.start();
    }

    //监听键盘的输入
    @Override
    public void keyReleased(KeyEvent e) {

    }


}
