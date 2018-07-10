package graphical;

import javafx.scene.control.Tab;
import sun.plugin.viewer.context.DefaultPluginAppletContext;

import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.xml.soap.Text;
import java.awt.event.*;
import java.awt.*;
import java.util.Vector;

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
    Object Tab[][] = new String[30][5];
    //comBox = new JComboBox<String>();
    Box BaseBox,Box1,Box2,Box3,Box4,Box5,Box6,box1,box2,box3;
    String name[] = {"工号","姓名","性别","年龄","所属部门"};  //表格组件
    String username = null;
    int au_id = 0;
    int department_id = 0;
    public Delete_interface(){}
    public Delete_interface(String s,String username,int au_id,int department_id){     //带参构造
        this.au_id = au_id;
        this.department_id = department_id;
        this.username = username;

        init(s);
        setLocation(560,100);
        setSize(830,750);
        setVisible(true);
        setResizable(false);
        validate();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    void init(String s){
        setTitle(s);                                   //设置窗口标题
        setLayout(new FlowLayout());

        comBox = new JComboBox();         //下拉列表框
        comBox.addItem("所属部门");
        comBox.addItem("工号");
        comBox.addItem("姓     名");

        comBox.addActionListener(this);




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

        //tablemodel = new DefaultTableModel(Tab,name);
        table = new JTable();//表格
        table.setModel(new DefaultTableModel(Tab,name));
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                selectRowMousePressed(e);
            }
        });

        setSize(200,200);
        id = new JButton("删除");               //按钮
        retu = new JButton("清除");
        clear = new JButton("退出");
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
    public void selectRowMousePressed(MouseEvent e){  //选中行鼠标事件
        System.out.println("鼠标事件捕获");
        int selectedRow = this.table.getSelectedRow();
        System.out.println("选中行的姓名："+table.getValueAt(selectedRow,1));
//        this.wordwidTxt.setText(table.getValueAt(selectedRow,0)+"");
//        this.wordTxt.setText(table.getValueAt(selectedRow, 1)+"");
//        this.vocabularyCb.setSelectedItem(table.getValueAt(selectedRow, 2));
//        this.meaningListTxt.setText(table.getValueAt(selectedRow, 3)+"");
//        this.egTxt.setText(table.getValueAt(selectedRow, 4)+"");
//        this.transTxt.setText(table.getValueAt(selectedRow, 5)+"");
    }

    public void show_result(String Tab[][]){
        DefaultTableModel model = (DefaultTableModel) this.table.getModel();
        model.setRowCount(0);
        for (int i=0;i< Tab.length;i++) {
            Vector row = new Vector();
            row.add(Tab[i][0]);
            row.add(Tab[i][1]);
            row.add(Tab[i][2]);
            row.add(Tab[i][3]);
            row.add(Tab[i][4]);

            model.addRow(row);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String search_thing = text.getText();
        Object box = e.getSource();
        int select_num = comBox.getSelectedIndex(); //下拉列表选中的结果
        switch (e.getActionCommand()){
            case "查询":
                System.out.println("查询字符串为："+search_thing);
                if (search_thing.length() == 0){
                    JOptionPane.showMessageDialog(null,"搜索关键词不能为空","搜索提示",JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
                else {
                    System.out.println("combox选中数字为："+select_num);
                    if (select_num == 0){   //按部门
                        if (au_id == 0){
                            Tab = sql_excute.search_by_department(search_thing);
                        }
                        else {
                            text.setText(Integer.toString(department_id));
                            Tab = sql_excute.search_by_department_notadmin_deleteinterface(Integer.toString(department_id));
                        }

                        show_result((String[][]) Tab);
                    }
                    else if (select_num == 1){    //按工号

                        Tab = sql_excute.search_by_userid(search_thing,au_id,department_id);
                        show_result((String[][]) Tab);
                    }
                    else{   //按姓名
                        Tab = sql_excute.search_by_username(search_thing,au_id,department_id);

                        show_result((String[][]) Tab);
                    }
                }
                //new data_show(Tab,name);
                //table.repaint();

                break;
            case "删除":
                int selectedRow = this.table.getSelectedRow();
                System.out.println("删除的姓名："+table.getValueAt(selectedRow,1));
                sql_excute.delete_by_id((String) table.getValueAt(selectedRow,0));
                String username = (String) table.getValueAt(selectedRow,1);
                JOptionPane.showMessageDialog(null,username+"已经被删除","删除提示",JOptionPane.INFORMATION_MESSAGE);
                Tab = sql_excute.search_by_department(search_thing);
                show_result((String[][]) Tab);
                break;

            case "清除":
                String[][] table_null = new String[30][5];
                show_result(table_null);
                break;

            case "退出":
                dispose();
                break;

            case "工号":
                System.out.println("下拉列表捕获");
        }

    }
}