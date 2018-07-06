package graphical;


import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class admin_menu extends JFrame implements ActionListener {

    JMenuBar menubar;   //创建菜单栏;
    JMenu menu1,menu2,menu3,menu4;         //创建菜单名；员工信息管理、员工信息查询、系统维护、帮助
    JMenuItem item1,item2,item3,item4;          //创建菜单项1；录入、修改、删除。
    JMenuItem query1,query2,query3;          //创建菜单项2；录入、修改、删除。
    JMenuItem maintain1,maintain2;          //创建菜单项3；修改密码、数据备份。
    public admin_menu(){}
    public admin_menu(String s,int x,int y,int w,int h){     //带参构造
        init(s);
        setLocation(x,y);
        setSize(w,h);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    void init(String s){
        setTitle(s);
        menubar = new JMenuBar();
        menu1 = new JMenu("员工信息管理");
        menu2 = new JMenu("员工信息查询");
        menu3 = new JMenu("系统维护");
        menu4 = new JMenu("帮助");
        item1 = new JMenuItem("录入");
        item1.setAccelerator(KeyStroke.getKeyStroke('S'));
        item2 = new JMenuItem("修改");
        item2.setAccelerator(KeyStroke.getKeyStroke('F'));
        item3 = new JMenuItem("删除");
        item3.setAccelerator(KeyStroke.getKeyStroke('D'));
        item4 = new JMenuItem("关于");

        item4.addActionListener(this);     //添加监听器
        item3.addActionListener(this);
        item2.addActionListener(this);
        item1.addActionListener(this);

        query1 = new JMenuItem("按员工");
        query2 = new JMenuItem("按部门");
        query3 = new JMenuItem("按工号");
        maintain1 = new JMenuItem("修改密码");
        maintain2 = new JMenuItem("数据备份");
        menu1.add(item1);
        menu1.addSeparator();//横线分隔符
        menu1.add(item2);
        menu1.addSeparator();
        menu1.add(item3);
        menu2.add(query1);
        menu2.addSeparator();
        menu2.add(query2);
        menu2.addSeparator();
        menu2.add(query3);
        menu3.add(maintain1);
        menu3.addSeparator();
        menu3.add(maintain2);
        menu4.add(item4);
        menubar.add(menu1);
        menubar.add(menu2);
        menubar.add(menu3);
        menubar.add(menu4);
        setJMenuBar(menubar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "关于":
                System.out.println("关于界面操作捕获");
                JOptionPane.showMessageDialog(null,"About","2018",JOptionPane.INFORMATION_MESSAGE);
                break;
            case "修改":
                System.out.println("修改界面操作捕获");
                admin_modify_interface admin = new admin_modify_interface();
                admin.user("信息修改界面");
                break;
            case "录入":
                System.out.println("录入界面操作捕获");
                new register();
                break;

            case "删除":
                System.out.println("删除界面操作捕获");
                new Delete_interface("删除界面");
                break;

        }
    }
}



