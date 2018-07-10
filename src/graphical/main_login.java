package graphical;


import java.awt.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

import static java.awt.Font.PLAIN;


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
        char[] tmp = ("23456789abdefhjkmnpqrstuvwxyzABDEFHJKMNPQRSTUVWXYZ").toCharArray();
        for(int i = 0;i<4;i++)
        {
            int pos = r.nextInt(tmp.length);
            char c = tmp[pos];

            sb.append(c + " ");
            current_sb.append(c);
        }
        g.drawString(sb.toString(), 10, 20);//写入验证码
    }
}


public class main_login extends JFrame implements ActionListener {
    JLabel userLa;
    JLabel pwdLa;
    JLabel sureBt1;
    JLabel verCodeLa;//验证码
    JTextField userTxt;
    JPasswordField pwdTxt;
    JTextField verCodeTxt;//验证码
    JButton sureBt;
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



        sureBt1 = new JLabel("企业员工管理系统");
        sureBt1.setFont(new Font("楷体", Font.BOLD | Font.ITALIC, 55));
        sureBt1.setForeground(Color.BLACK);
        sureBt1.setSize(500, 60);
        sureBt1.setLocation(150, 90);
       // sureBt1.addActionListener(this);

        //用户文本
        userLa = new JLabel();
        userLa.setText("用户名：");
        userLa.setFont(new Font("宋体", Font.BOLD, 20));
        userLa.setSize(100, 50);
        userLa.setLocation(250, 195);

        //密码文本
        pwdLa = new JLabel();
        pwdLa.setText("密码：");
        pwdLa.setSize(100, 50);
        pwdLa.setFont(new Font("宋体", Font.BOLD, 20));
        pwdLa.setLocation(250, 255);

        //用户输入框
        userTxt = new JTextField();
        userTxt.setSize(120, 30);
        //this.setSize(width, height)
        userTxt.setOpaque(false);
        userTxt.setLocation(350, 205);

        //密码输入框
        pwdTxt = new JPasswordField();
        pwdTxt.setSize(120, 30);
        pwdTxt.setOpaque(false);
        pwdTxt.setLocation(350, 255);

        //确认按钮
        sureBt = new JButton("登陆");
        sureBt.setSize(90, 35);
        sureBt.setLocation(240, 400);


        //退出按钮
        quitBt = new JButton("退出");
        quitBt.setSize(90, 35);
        quitBt.setLocation(460, 400);
        sureBt.addActionListener(this);
        quitBt.addActionListener(this);


        //验证码文本
        verCodeLa = new JLabel();
        verCodeLa.setText("验证码：");
        verCodeLa.setFont(new Font("宋体", Font.BOLD, 20));
        verCodeLa.setSize(100, 40);
        verCodeLa.setLocation(250, 315);

        //验证码文本框
        verCodeTxt = new JTextField();
        verCodeTxt.setSize(120, 30);
        verCodeTxt.setLocation(350, 315);
        verCodeTxt.setOpaque(false);

        //验证码
        mp = new verification_code();
        mp.setSize(90, 30);
        mp.setLocation(500, 315);

        // 加载背景图片
        ImageIcon bg = new ImageIcon("./src/login.jpg");
        // 把背景图片显示在一个标签里
        JLabel label = new JLabel(bg);
        //把标签的大小位置设置为图片刚好填充整个面
        label.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight());
        //添加图片到frame的第二层
        this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        //获取frame的最上层面板为了设置其背景颜色(JPanel有设置透明的方法)
        JPanel jp=(JPanel)this.getContentPane();
        jp.setOpaque(false);//设置透明

        setLayout(null);
        setSize(800,560);
        setLocation(570, 230);



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
        this.setResizable(false);
        this.setVisible(true);
    }

    public void move(){
        try{
            int i,j;
            for(i=200;i<250;i++){
                for(j=0;j<500;j+=5)
                    this.setLocation(i,j);
                Thread.sleep(10);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
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
        int au_id = 0;
        int user_id = 0;
        boolean username_status = true;
        if (username.length()!=0&&passwd.length()!=0){
            result =  sql_excute.sql_connect(username,passwd);
            au_id = sql_excute.get_authority(username);
            user_id = sql_excute.by_name_get_userid(username);  //获取当前用户 user_id
            //username_status = sql_excute.get_all_username(username);
        }


        System.out.println("passwd:"+passwd);
        System.out.println(code+current_code);
        System.out.println("登陆判断结果："+result);
        switch (e.getActionCommand()) {

            case "登陆":
                if (username.length()!=0 & passwd.length()!=0 & code.length()!=0) {
                    if (username_status == true){
                        if (result == true & code.equals(current_code) & au_id == 0){ //管理员身份
                            JOptionPane.showMessageDialog(null,"Welcome Back ! "+username +"您的身份是管理员","登陆提示",JOptionPane.INFORMATION_MESSAGE);
                            new admin_menu("管理员主菜单",username,au_id,user_id,570,230,800,560);  //主键参数传输
                            this.dispose();
                        }
                        else if (result == true & code.equals(current_code) & au_id == 1){  //部长
                            JOptionPane.showMessageDialog(null,"Welcome Back! "+username+"您的身份是部长","登陆提示",JOptionPane.INFORMATION_MESSAGE);
                            new admin_menu("部长主菜单",username,au_id,user_id,570,230,800,500);
                            this.dispose();
                        }
                        else if (result == true & code.equals(current_code) & au_id == 2){   //普通用户
                            JOptionPane.showMessageDialog(null,"Welcome Back! "+username+"您的身份是员工","登陆提示",JOptionPane.INFORMATION_MESSAGE);
                            new user_menu("用户主菜单", Integer.toString(user_id));
                            this.dispose();
                        }
                        else {
                            JOptionPane.showMessageDialog(null,"用户名、密码或者验证码错误","登陆提示",JOptionPane.INFORMATION_MESSAGE);
                            //new main_login();
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"用户名不存在","登陆提示",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"用户名、密码不能为空","登陆提示",JOptionPane.WARNING_MESSAGE);
                }
                break;

            case "退出":
                dispose();
                break;

            case "企业员工管理系统":
                this.move();
                break;

        }
    }
}

