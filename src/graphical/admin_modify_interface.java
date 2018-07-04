package graphical;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class admin_modify_interface extends JFrame implements ActionListener {
    JPanel p=new JPanel();
    JTable table;
    Object a[][];
    Object name[] = {"姓名","性别","年龄","所属部门","工号","登录密码"};
    JButton button;
    public void user(String s){
        setTitle(s);
        button = new JButton("修改");             //最下方修改按钮

        a = new Object[45][6];
        table = new JTable(a,name);           //表格
        Container con = getContentPane();
        getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
        con.add(button,BorderLayout.SOUTH);

        //在上方嵌套FlowLayout布局
        p.setLayout(new FlowLayout(1,5,5));
        JLabel text = new JLabel("输入用户信息：");
        JTextField in=new JTextField(10);
        JButton search = new JButton("搜索");
        search.addActionListener(this);
        p.add(text);
        p.add(in);           //将按钮添加到面板中
        p.add(search);
        text.setBounds(0,0,30,30);
        in.setBounds(0,0,30,30);
        search.setBounds(0,0,30,30);
        getContentPane().add("North",p);

        //窗口尺寸
        setSize(400,400);
        setLocation(350, 160);
        setVisible(true);
        validate();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "搜索":
//                dispose();
        }
    }
}

