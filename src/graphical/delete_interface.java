package graphical;

import javax.swing.*;
import javax.xml.soap.Text;
import java.awt.event.*;
import java.awt.*;

class Delete_interface extends JFrame implements ActionListener {

    JMenuBar menubar;   //创建菜单栏;
    JMenu menu1,menu2,menu3,menu4;         //创建菜单名；员工信息管理、员工信息查询、系统维护、帮助
    JMenuItem item1,item2,item3;          //创建菜单项1；录入、修改、删除。
    JMenuItem query1,query2,query3;          //创建菜单项2；录入、修改、删除。
    JMenuItem maintain1,maintain2;          //创建菜单项3；修改密码、数据备份。
    JButton id,retu,clear,find;                  //创建按钮：清空，返回，删除,查询。
    JTextField text;                         //创建单行文本框
    JTextArea ate1;                           //创建多行文本框
    JComboBox comBox;    //下拉列表
    JTable table;
    Object Tab[][] = new Object[30][5];
    //comBox = new JComboBox<String>();
    Box BaseBox,Box1,Box2,Box3,Box4,Box5,Box6,box1,box2,box3;
    public Delete_interface(){}
    public Delete_interface(String s){     //带参构造

        init(s);
        setLocation(300,50);
        setSize(800,750);
        setVisible(true);
        validate();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    void init(String s){
        setTitle(s);                                   //设置窗口标题
        setLayout(new FlowLayout());

        comBox = new JComboBox();         //下拉列表框
        comBox.addItem("工号");
        comBox.addItem("所属部门");
        comBox.addItem("姓     名");

        Object name[] = {"工号","姓名","性别","年龄","所属部门"};  //表格组件


        text = new JTextField(10);                  //文本框

        BaseBox = Box.createVerticalBox();         //盒子布局 最外层列，再是三个行，再是列。
        Box1 =Box.createHorizontalBox();
        Box2 =Box.createHorizontalBox();
        Box3 =Box.createHorizontalBox();
        Box4 =Box.createHorizontalBox();
        Box5 =Box.createHorizontalBox();
        Box6 =Box.createHorizontalBox();
        box1 =Box.createVerticalBox();
        box2 =Box.createVerticalBox();
        box3 =Box.createVerticalBox();


        table = new JTable(Tab,name);           //表格

        setSize(200,200);
        id = new JButton("删除");               //按钮
        retu = new JButton("返回");
        clear = new JButton("清除");
        find = new JButton("查询");
        add(id);
        add(retu);
        add(clear);
        add(find);

        find.addActionListener(this);
        id.addActionListener(this);
        retu.addActionListener(this);
        clear.addActionListener(this);
        find.addActionListener(this);

        Box4.add(Box.createVerticalStrut(50));
        box1.add(comBox);

        box2.add(text);
        box2.add(Box.createHorizontalStrut(40));
        box3.add(find);


        Box1.add(box1);
        Box1.add(box2);
        Box1.add(box3);

        Box5.add(Box.createVerticalStrut(50));  //5,6为空盒子,用来调整间距.
        Box2.add(new JScrollPane(table));
        Box6.add(Box.createVerticalStrut(50));

        Box3.add(id);
        Box3.add(Box.createHorizontalStrut(150));
        Box3.add(retu);
        Box3.add(Box.createHorizontalStrut(150));
        Box3.add(clear);

        BaseBox.add(Box4);
        BaseBox.add(Box1);
        BaseBox.add(Box5);
        BaseBox.add(Box2);
        BaseBox.add(Box6);
        BaseBox.add(Box3);
        add(BaseBox);


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
        maintain1 = new JMenuItem("修改密码");
        maintain2 = new JMenuItem("数据备份");
        menu1.add(item1);
        menu1.addSeparator();//横线分隔符
        menu1.add(item2);
        menu1.addSeparator();
        menu1.add(item3);
        menu3.add(maintain1);
        menu3.addSeparator();
        menu3.add(maintain2);
        menubar.add(menu1);
        menubar.add(menu2);
        menubar.add(menu3);
        menubar.add(menu4);
        setJMenuBar(menubar);
    }
    public void find(){                  //查询方法

    }
    public void delete(){				//删除方法

    }
    public void clear(){ 				//清空方法

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(text);
        String search_thing = text.getText();
        switch (e.getActionCommand()){
            case "查询":
                Tab = sql_excute.search_by_id(search_thing);

                table.repaint();
                table.repaint();
                break;
            case "删除":

                break;

            case "清除":

                break;
        }

    }
}