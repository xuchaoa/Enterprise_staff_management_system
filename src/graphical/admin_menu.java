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
    int au_id = 0;
    int user_id = 0;
    String username = null;
    int departmrnt_id = 0;
    public admin_menu(){}
    public admin_menu(String s,String username,int au_id,int user_id,int x,int y,int w,int h){
        this.au_id = au_id;  //主键跟随
        this.username = username;
        this.user_id = user_id;

        setLayout(null);
        init(s);
        setLocation(x,y);
        setSize(w,h);

        setResizable(false);
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
        item4 = new JMenuItem("关于");

        item4.addActionListener(this);     //添加监听器
        item2.addActionListener(this);
        item1.addActionListener(this);



        JLabel aa = new JLabel("企业员工管理系统");
        add(aa);
        aa.setBounds(145,30,500,310);
        //aa.setForeground(Color.RED);
        aa.setFont(new Font("楷体", Font.BOLD, 55));


        JButton c=new JButton("注销");
        add(c);
        c.setBounds(190,350,90,40);
        JButton e=new JButton("退出");
        add(e);
        e.setBounds(490,350,90,40);

        c.addActionListener(this);
        e.addActionListener(this);

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



        query1 = new JMenuItem("查询和删除");
        maintain2 = new JMenuItem("数据备份");
        menu1.add(item1);
        menu1.addSeparator();//横线分隔符
        menu1.add(item2);
        menu1.addSeparator();
        menu2.add(query1);
        menu2.addSeparator();
        menu3.add(maintain2);
        menu4.add(item4);
        menubar.add(menu1);
        menubar.add(menu2);
        menubar.add(menu3);
        menubar.add(menu4);
        setJMenuBar(menubar);

        query1.addActionListener(this);
        maintain2.addActionListener(this);
    }

@Override
   public void actionPerformed(ActionEvent e) {
        departmrnt_id = sql_excute.get_departmentid_by_userid(user_id);  //获取部门信息
        switch (e.getActionCommand()){
            case "关于":
                System.out.println("关于界面操作捕获");
                JOptionPane.showMessageDialog(null,"Archerx","About",JOptionPane.INFORMATION_MESSAGE);
                break;
            case "修改":
                System.out.println("修改界面操作捕获");   // 管理员和部长管理人员变化
                admin_modify_interface admin = new admin_modify_interface(au_id,departmrnt_id);
                admin.setVisible(true);
                break;
            case "录入":
                System.out.println("录入界面操作捕获");
                new register();
                break;

            case "查询和删除":
                System.out.println("查询和删除界面操作捕获");
                new Delete_interface("查询&删除界面",username,au_id,departmrnt_id);
                break;

            case "注销":
                System.out.println("注销按钮捕获");
                dispose();
                new main_login();
                break;
            case "退出":
                System.out.println("退出界面捕获");
                dispose();
                break;
            case "数据备份":
                System.out.println("数据备份界面捕获");
                String back_path = sql_excute.database_backup();
                JOptionPane.showMessageDialog(null,"成功备份到："+back_path,"备份成功",JOptionPane.INFORMATION_MESSAGE);
                break;

        }
    }
}
