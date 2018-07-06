package graphical;


import java.awt.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


class verification_code extends Panel {
    StringBuilder sb = new StringBuilder();
    StringBuilder current_sb = new StringBuilder();
    public void paint(Graphics g)
    {
        int height = 50;
        int width = 90;
        //验证码框背景颜色
        g.setColor(Color.LIGHT_GRAY);
        //填充验证码背景
        g.fillRect(0, 0, width, height);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, width-1, height-1);
        Random r = new Random();
        //设置干扰点
        for(int i = 0;i<100;i++)
        {
            int x = r.nextInt(width)-1;
            int y = r.nextInt(height)-1;
            g.drawOval(x, y, 2, 2);
        }
        g.setFont(new Font("黑体",Font.BOLD,20));//设置验证码字体以及大小
        g.setColor(Color.RED);//设置验证码字体颜色
        //生成随机验证码
        char[] tmp = ("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
        for(int i = 0;i<4;i++)
        {
            int pos = r.nextInt(tmp.length);
            char c = tmp[pos];

            sb.append(c + " ");
            current_sb.append(c);
        }
        g.drawString(sb.toString(), 10, 15);//写入验证码
    }
}


public class main_login extends JFrame implements ActionListener {
    JLabel userLa;
    JLabel pwdLa;
    JLabel verCodeLa;//验证码
    JTextField userTxt;
    JPasswordField pwdTxt;
    JTextField verCodeTxt;//验证码
    JButton sureBt;
    JButton sureBt1;
    JButton quitBt;
    verification_code mp;


    //构造方法
    public main_login() {
        setTitle("用户登录");
        Init();
    }

    public void Init() {
        Frame frame = new Frame("用户登录");

        //创建出控件对象（因为上面只是声明出来，并没有给出实际的空间)

        sureBt1 = new JButton("企业员工管理系统");
        sureBt1.setSize(300, 40);
        sureBt1.setLocation(70, 30);

        //用户文本
        userLa = new JLabel();
        userLa.setText("用户名：");
        userLa.setSize(60, 50);
        userLa.setLocation(100, 80);

        //密码文本
        pwdLa = new JLabel();
        pwdLa.setText("密码：");
        pwdLa.setSize(50, 50);
        pwdLa.setLocation(100, 120);

        //用户输入框
        userTxt = new JTextField();
        userTxt.setSize(100, 20);
        //this.setSize(width, height)
        userTxt.setLocation(170, 95);

        //密码输入框
        pwdTxt = new JPasswordField();
        pwdTxt.setSize(100, 20);
        pwdTxt.setLocation(170, 135);

        //确认按钮
        sureBt = new JButton("登陆");
        sureBt.setSize(60, 25);
        sureBt.setLocation(135, 260);


        //退出按钮
        quitBt = new JButton("退出");
        quitBt.setSize(60, 25);
        quitBt.setLocation(240, 260);
        sureBt.addActionListener(this);
        quitBt.addActionListener(this);
        //验证码文本
        verCodeLa = new JLabel();
        verCodeLa.setText("验证码：");
        verCodeLa.setSize(60, 50);
        verCodeLa.setLocation(100, 165);

        //验证码文本框
        verCodeTxt = new JTextField();
        verCodeTxt.setSize(100, 20);
        verCodeTxt.setLocation(170, 180);

        //验证码
        mp = new verification_code();
        mp.setSize(100, 30);
        mp.setLocation(280, 175);


        setLayout(null);
        setSize(470, 370);
        setLocation(330, 170);
        add(sureBt1);
        add(userLa);                   //添加用户文本
        add(pwdLa);                 //添加密码文本
        add(userTxt);              //添加用户文本框
        add(pwdTxt);                //添加密码文本框
        add(sureBt);              //添加登录按钮
        add(quitBt);             //添加退出按钮
        add(verCodeLa);           //添加验证码文本
        add(verCodeTxt);         //添加验证码文本框
        add(mp);                     //添加验证码
        //  sureBt.addActionListener(this);
        //  quitBt.addActionListener(this);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = new String();
        String passwd = new String();
        String code = new String();
        username = userTxt.getText();   //用户名获取
        passwd = pwdTxt.getText();     //密码获取
        code = verCodeTxt.getText();  //输入验证码获取
        String current_code = mp.current_sb.toString().toLowerCase();   //实际验证码获取

        //sql_excute sql = new sql_excute();
        System.out.println(username+passwd+code);
        boolean result = false;
        if (username.length()!=0&&passwd.length()!=0){
            result =  sql_excute.sql_connect(username,passwd);
        }

        System.out.println("passwd:"+passwd);
        System.out.println(code+current_code);
        System.out.println(code.equals(current_code));
        switch (e.getActionCommand()) {

            case "登陆":
                if (username == null| passwd == null|code == null){
                    JOptionPane.showMessageDialog(null,"用户名和密码不能为空","登陆提示",JOptionPane.WARNING_MESSAGE);
                }
                if (username.length()!=0 & passwd.length()!=0&code.length()!=0) {
                    if (result == true & code.equals(current_code)&username.equals("admin")){
                        JOptionPane.showMessageDialog(null,"Welcome Back! "+username,"登陆提示",JOptionPane.INFORMATION_MESSAGE);
                        new admin_menu("主菜单",10,10,500,500);
                        this.dispose();
                    }
                    else if (result == true & code.equals(current_code)){
                        JOptionPane.showMessageDialog(null,"Welcome Back! "+username,"登陆提示",JOptionPane.INFORMATION_MESSAGE);
                        new admin_menu("主菜单",10,10,500,500);
                        this.dispose();

                    }
                    else {
                        JOptionPane.showMessageDialog(null,"用户名、密码或者验证码错误","登陆提示",JOptionPane.INFORMATION_MESSAGE);
                        //new main_login();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"用户名、密码不能为空","登陆提示",JOptionPane.WARNING_MESSAGE);
                }
                break;

            case "退出":
                dispose();
                break;

        }
    }
}

