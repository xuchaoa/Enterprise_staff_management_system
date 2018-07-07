package graphical;

import javax.swing.*;
import java.awt.*;

public class data_show extends JFrame {
    public data_show(String a[][],String name[]){
        JPanel p=new JPanel();
        JTable table;
//        Object a[][] = new Object[45][6];
//        Object name[] = {"姓名","性别","年龄","所属部门","工号","登录密码"};


        table = new JTable(a,name);           //表格
        Container con = getContentPane();
        getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
        //在上方嵌套FlowLayout布局
        p.setLayout(new FlowLayout(1,5,5));
        getContentPane().add("North",p);
        //窗口尺寸
        setSize(500,500);
        setLocation(350, 160);
        setVisible(true);
        validate();
        setTitle("查询结果");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
