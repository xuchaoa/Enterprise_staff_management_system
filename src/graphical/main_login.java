//package graphical;
//
//
//import java.awt.*;
//        import java.io.*;
//        import java.awt.event.*;
//        import javax.swing.*;
//
//public class main_login extends JFrame {
//    JLabel userLa;
//    JLabel pwdLa;
//    JLabel verCodeLa;//验证码
//    JTextField userTxt;
//    JPasswordField pwdTxt;
//    JTextField verCodeTxt;//验证码
//    JButton sureBt;
//    JButton sureBt1;
//    JButton quitBt;
//    Mypanel mp;
//
//    //构造方法
//    public QQGUI()
//    {
//        setTitle("用户登录");
//        Init();
//    }
//    public void Init()
//    {
//        Frame frame = new Frame("用户登录");
//
//        //创建出控件对象（因为上面只是声明出来，并没有给出实际的空间)
//
//        sureBt1 = new JButton("企业员工管理系统");
//        sureBt1.setSize(300, 40);
//        sureBt1.setLocation(70, 30);
//
//        //用户文本
//        userLa = new JLabel();
//        userLa.setText("用户名：");
//        userLa.setSize(60, 50);
//        userLa.setLocation(100, 80);
//
//        //密码文本
//        pwdLa = new JLabel();
//        pwdLa.setText("密码：");
//        pwdLa.setSize(50, 50);
//        pwdLa.setLocation(100, 120);
//
//        //用户输入框
//        userTxt = new JTextField();
//        userTxt.setSize(100, 20);
//        //this.setSize(width, height)
//        userTxt.setLocation(170, 95);
//
//        //密码输入框
//        pwdTxt = new JPasswordField();
//        pwdTxt.setSize(100, 20);
//        pwdTxt.setLocation(170, 135);
//
//        //确认按钮
//        sureBt = new JButton("登录");
//        sureBt.setSize(60, 25);
//        sureBt.setLocation(135, 260);
//
//        //退出按钮
//        quitBt = new JButton("退出");
//        quitBt.setSize(60, 25);
//        quitBt.setLocation(240, 260);
//
//        //验证码文本
//        verCodeLa = new JLabel();
//        verCodeLa.setText("验证码：");
//        verCodeLa.setSize(60, 50);
//        verCodeLa.setLocation(100,165);
//
//        //验证码文本框
//        verCodeTxt = new JTextField();
//        verCodeTxt.setSize(100, 20);
//        verCodeTxt.setLocation(170, 180);
//
//        //验证码
//        mp = new Mypanel();
//        mp.setSize(100, 30);
//        mp.setLocation(280, 175);
//
//
//        setLayout(null);
//        setSize(470, 370);
//        setLocation(330,170);
//        add(sureBt1);
//        add(userLa);                   //添加用户文本
//        add(pwdLa);                 //添加密码文本
//        add(userTxt);              //添加用户文本框
//        add(pwdTxt);                //添加密码文本框
//        add(sureBt);              //添加登录按钮
//        add(quitBt);             //添加退出按钮
//        add(verCodeLa);           //添加验证码文本
//        add(verCodeTxt);         //添加验证码文本框
//        add(mp);                     //添加验证码
//        //  sureBt.addActionListener(this);
//        //  quitBt.addActionListener(this);
//        this.setVisible(true);
//    }
//
//
//}
