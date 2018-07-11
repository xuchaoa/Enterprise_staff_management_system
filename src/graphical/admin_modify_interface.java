package graphical;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class admin_modify_interface extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    JTable table;

    String Tab[][] = new String[30][6];
    String modify_data[] = new String[6];
    int au_id = 0;
    int department_id = 0;


    public admin_modify_interface(int au_id,int department_id) {
        this.au_id = au_id;
        this.department_id = department_id;
        setTitle("信息修改界面");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(670, 350, 550, 370);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        JLabel label = new JLabel("部门编号");
        label.setBounds(10, 291, 54, 23);
        contentPane.add(label);

        textField = new JTextField();
        textField.setBounds(62, 291, 103, 26);
        contentPane.add(textField);
        textField.setColumns(10);


        JButton button = new JButton("搜索");
        button.setBounds(198, 291, 68, 30);
        contentPane.add(button);

        JButton button_1 = new JButton("保存");
        button_1.setBounds(320, 291, 68, 30);
        contentPane.add(button_1);

        JButton btnexcel = new JButton("退出");
        btnexcel.setBounds(456, 291, 68, 30);

        button.addActionListener(this);
        button_1.addActionListener(this);
        btnexcel.addActionListener(this);

        contentPane.add(btnexcel);

        JLabel label_1 = new JLabel("姓名");
        label_1.setBounds(364, 17, 54, 15);
        contentPane.add(label_1);

        textField_1 = new JTextField();
        textField_1.setBounds(428, 14, 96, 21);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JLabel label_2 = new JLabel("\u6027\u522B");
        label_2.setBounds(364, 61, 54, 15);
        contentPane.add(label_2);

        JLabel label_3 = new JLabel("\u5E74\u9F84");
        label_3.setBounds(364, 102, 54, 15);
        contentPane.add(label_3);

        JLabel label_4 = new JLabel("\u6240\u5C5E\u90E8\u95E8");
        label_4.setBounds(364, 144, 54, 15);
        contentPane.add(label_4);

        JLabel label_5 = new JLabel("\u5DE5\u53F7");
        label_5.setBounds(364, 184, 54, 15);
        contentPane.add(label_5);

        JLabel lblNewLabel = new JLabel("\u767B\u5F55\u5BC6\u7801");
        lblNewLabel.setBounds(364, 230, 54, 15);
        contentPane.add(lblNewLabel);

        textField_2 = new JTextField();
        textField_2.setBounds(428, 58, 96, 21);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setBounds(428, 99, 96, 21);
        contentPane.add(textField_3);
        textField_3.setColumns(10);

        textField_4 = new JTextField();
        textField_4.setBounds(428, 141, 96, 21);
        contentPane.add(textField_4);
        textField_4.setColumns(10);

        textField_5 = new JTextField();
        textField_5.setBounds(428, 181, 96, 21);
        contentPane.add(textField_5);
        textField_5.setColumns(10);

        textField_6 = new JTextField();
        textField_6.setBounds(428, 227, 96, 21);
        contentPane.add(textField_6);
        textField_6.setColumns(10);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(62, 79, 2, 2);
        contentPane.add(scrollPane);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(10, 10, 344, 263);
        contentPane.add(scrollPane_1);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                },
                new String[] {
                        "\u59D3\u540D", "\u6027\u522B", "\u5E74\u9F84", "\u6240\u5C5E\u90E8\u95E8", "\u5DE5\u53F7", "\u767B\u5F55\u5BC6\u7801"
                }
        ));
        scrollPane_1.setViewportView(table);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                selectRowMousePressed(e);
            }
        });
    }

    public void selectRowMousePressed(MouseEvent e){  //选中行鼠标事件
        System.out.println("鼠标事件捕获");
        int selectedRow = this.table.getSelectedRow();
        System.out.println("选中行的姓名："+table.getValueAt(selectedRow,0));
        this.textField_1.setText((String) table.getValueAt(selectedRow,0));
        this.textField_2.setText((String) table.getValueAt(selectedRow,1));
        this.textField_3.setText((String) table.getValueAt(selectedRow,2));
        this.textField_4.setText((String) table.getValueAt(selectedRow,3));
        this.textField_5.setText((String) table.getValueAt(selectedRow,4));
        this.textField_6.setText((String) table.getValueAt(selectedRow,5));

    }


    public void get_modify_data(){
        modify_data[0] = textField_1.getText();
        modify_data[1] = textField_2.getText();
        modify_data[2] = textField_3.getText();
        modify_data[3] = textField_4.getText();
        modify_data[4] = textField_5.getText();
        modify_data[5] = textField_6.getText();
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
            row.add(Tab[i][5]);

            model.addRow(row);
        }

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String search_string = textField.getText();
        System.out.println("获取到的搜索字符串："+search_string);
        switch (e.getActionCommand()){
            case "搜索":
                System.out.println("搜索按钮捕获");
                if (au_id == 0 & search_string.length() == 0){
                    JOptionPane.showMessageDialog(null,"搜索信息不能为空","搜索提示",JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    if (au_id == 0){
                        Tab = sql_excute.search_by_department_admin(Integer.parseInt(search_string));
                    }
                    else {
                        Tab = sql_excute.search_by_department_notadmin(department_id);
                        textField.setText(Integer.toString(department_id));
                    }
                    for (int i=0;i<Tab.length;i++){
                        for (int j=0;j<6;j++){
                            System.out.print(Tab[i][j]+" ");
                        }
                        System.out.println();
                    }
                    show_result(Tab);
                    break;

                }
                break;
            case "保存":
                get_modify_data();
                System.out.println("修改后数据如下");
                for (int i=0;i<6;i++){
                    System.out.print(modify_data[i]+" ");
                }
                sql_excute.updata_modify_data(modify_data);

                JOptionPane.showMessageDialog(null,modify_data[4]+"修改成功","修改提示",JOptionPane.INFORMATION_MESSAGE);
                Tab = sql_excute.search_by_userid_modify(modify_data[4]);
                show_result(Tab);
                break;
            case "退出":
                dispose();
                break;
        }
    }
}
