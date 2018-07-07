package graphical;

import javax.swing.*;

import java.awt.*;
import java.io.*;

public class start_interface extends JFrame {
    public start_interface(){

        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        JLabel jb1 =new JLabel();
        JLabel jb2 = new JLabel("企业员工管理系统");



        JProgressBar Bar = new JProgressBar();   //进度条控件
        Bar.setStringPainted(true);              //进度条字符串
        Bar.setSize(250, 30);
        //Bar.setBackground(getBackground(BLACK));
        Bar.setBounds(350, 400, 250, 30);

        ImageIcon img1 = new ImageIcon("6.jpg");// 登陆背景图
        //ImageIcon img2 = new ImageIcon("7.jpg");// 登陆背景图
        label.setIcon(img1);
        label.setLocation(100, 50);
        //label.setIcon(img2);




        //panel.setBackground(Color.gray);   //画板背景
        this.setSize(1000,500);
        this.setLocation(200,50);
        //setLocationRelativeTo(null);   //组件当前未显示或者 c 为 null，则此窗口将置于屏幕的中央。



        jb2.setForeground(Color.BLACK);
        jb2.setFont(new Font("楷体", Font.BOLD, 40));
        jb2.setBounds(300,50,450,130);

        panel.setSize(600, 400);
        panel.add(label);


        this.add(panel);
        this.add(Bar);
        this.add(jb2);
        add(panel);

        //setExtendedState(JFrame.MAXIMIZED_BOTH);// JFrame最大化
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);// JFrame关闭
        setUndecorated(true);
        setVisible(true);// JFrame可见

        Bar.setIndeterminate(true);//进度条采用不明确显示进度的‘模糊模式’，
        for(int i=0;i<=100;i++) {
            Bar.setValue(i);
            //Thread.sleep(20);
        }

        dispose(); //关闭窗口
        setVisible(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Already there
        this.setExtendedState(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        try{
            Thread.sleep(2000);
        }catch (Exception E){

        }
        dispose();
    }


}
