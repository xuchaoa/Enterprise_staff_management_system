package graphical;



import javax.swing.*;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class user_menu extends JFrame implements ActionListener {
    String username = "admin";
    public user_menu (String s,String username) {
        setTitle(s);
        setLayout(null);                               //设置布局为空布局
        init();
        setSize(340,400);
        setLocation(350, 160);
        setVisible(true);
        validate();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    void init() {
        //创建并添加菜单栏
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        //创建并添加各菜单，注意：菜单的快捷键是同时按下Alt键和字母键，方法setMnemonic('F')是设置快捷键为Alt +Ｆ
        JMenu menuView = new JMenu("信息修改"),menuEdit = new JMenu("关于");
        menuView.setMnemonic('V');
        menuEdit.setMnemonic('E');
        menuBar.add(menuView);
        menuBar.add(menuEdit);


        //添加“查询”菜单的各菜单项
//        JMenu itemOpen = new JMenu("其他部门人员信息");
////        itemOpen.setMnemonic('O');
////        JMenuItem itemOpen1 = new JMenuItem("工号");
////        JMenuItem itemOpen2 = new JMenuItem("部门");
////        itemOpen.add(itemOpen1);
////        itemOpen.add(itemOpen2);
//        JMenuItem itemSave = new JMenuItem("查询信息");
//        itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
//        menuFile.add(itemSave);
//        itemSave.addActionListener(this);

       // 添加“信息修改”菜单的各菜单项
        JMenuItem itemStop = new JMenuItem("个人信息修改查询");
        itemStop.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
        menuView.add(itemStop);
        itemStop.addActionListener(this);

        //添加“关于”菜单的各菜单项
        JMenuItem itemCopy = new JMenuItem("关于");
        itemCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
        menuEdit.add(itemCopy);
        itemCopy.addActionListener(this);


        //插入图片
        JLabel jb1 =new JLabel();
        ImageIcon img = new ImageIcon("user.jpg");
        jb1.setIcon(img);
        add(jb1);
        jb1.setBounds(65, 20, 200, 200);


        // 加载背景图片
        ImageIcon bg = new ImageIcon("1.jpg");
        // 把背景图片显示在一个标签里
        JLabel label = new JLabel(bg);
        //把标签的大小位置设置为图片刚好填充整个面
        label.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight());
        //添加图片到frame的第二层
        this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        //获取frame的最上层面板为了设置其背景颜色(JPanel有设置透明的方法)
        JPanel jp=(JPanel)this.getContentPane();
        jp.setOpaque(false);//设置透明


        //设置面板内容

//        JButton b=new JButton("查询");
//        add(b);
//        b.setBounds(27,260,70,40);
        JButton c=new JButton("退出");
        add(c);
        c.setBounds(127,260,70,40);
        JButton e=new JButton("修改");
        add(e);
        e.setBounds(227,260,70,40);
        //b.addActionListener(this);
        c.addActionListener(this);
        e.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){

            case "个人信息修改查询":
                System.out.println("个人信息修改按钮捕获");
                new user_modify("admin");
                break;
            case "关于":
                System.out.println("关于按钮捕获");
                JOptionPane.showMessageDialog(null,"Archerx","about",JOptionPane.INFORMATION_MESSAGE);
                break;
            case "退出":
                System.out.println("退出按钮捕获");
                dispose();
                new main_login();
                break;
            case "修改":
                System.out.println("修改按钮捕获");
                new user_modify(username);
                break;
        }
    }
}

