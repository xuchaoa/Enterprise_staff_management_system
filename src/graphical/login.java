package graphical;


import javax.swing.*;
import java.awt.*;

public class login extends JFrame{
    Box box1,box2;
    public login(){
        setLayout(new FlowLayout());
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void init(){
//        setLayout(new FlowLayout());
//        JLabel username_ = new JLabel("username");
//        add(username_);
//        JTextField username = new JTextField(20);
//        add(username);
//
////        JLabel passwd_ = new JLabel("password");
////        add(passwd_);
////        JTextField passwd = new JTextField("20");
////        add(passwd);
//        JButton login_button = new JButton("login");
//        add(login_button);
        box1 = Box.createVerticalBox();  //初始化容器
        box1.add(new JLabel("username"));  //标签
        box1.add(Box.createVerticalStrut(10)); //设置垂直支撑
        box1.add(new JLabel("passwd"));  //标签

        box2 = Box.createVerticalBox();
        JTextField username = new JTextField(20);
        box2.add(Box.createVerticalStrut(10));  //设置间隔
        JTextField passwd = new JTextField(20);


        login_listener username_listener = new login_listener(); //添加监视器
        login_listener passwd_listener = new login_listener();
        username.addActionListener(username_listener);
        passwd.addActionListener(passwd_listener);

        box2.add(passwd);   //passwd
        box2.add(username);  //设置username文本输入框



        JButton login_button = new JButton("login");
        Box box3;
        box3 = Box.createVerticalBox();
        login_listener login_button_listener = new login_listener();
        login_button.addActionListener(login_button_listener);
        box3.add(login_button);
        add(login_button);

        Box login_basebox = Box.createHorizontalBox();
        login_basebox.add(box1);
        login_basebox.add(Box.createHorizontalStrut(20));
        login_basebox.add(box2);


        Box basebox;
        basebox = Box.createVerticalBox();
        basebox.add(login_basebox);
        basebox.add(Box.createVerticalStrut(100));
        basebox.add(box3);
        add(basebox);


    }

}
