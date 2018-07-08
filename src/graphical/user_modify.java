package graphical;




        import java.awt.EventQueue;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

        import javax.swing.*;
        import javax.swing.border.EmptyBorder;

public class user_modify extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;

    String user_data[][] = new String[30][6];  //查询结果存储
    String username;     //token
    /**
     * Create the frame.
     */
    public user_modify(String username) {
        this.username = username;

        setVisible(true);
        setTitle("个人信息查询修改");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel("\u59D3\u540D");
        label.setBounds(62, 10, 54, 15);
        contentPane.add(label);

        textField = new JTextField();
        textField.setBounds(140, 7, 89, 21);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel label_1 = new JLabel("\u6027\u522B");
        label_1.setBounds(62, 48, 54, 15);
        contentPane.add(label_1);

        textField_1 = new JTextField();
        textField_1.setBounds(140, 45, 89, 21);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JLabel label_2 = new JLabel("\u5E74\u9F84");
        label_2.setBounds(62, 93, 54, 15);
        contentPane.add(label_2);

        textField_2 = new JTextField();
        textField_2.setBounds(140, 90, 89, 21);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        JLabel label_3 = new JLabel("\u6240\u5C5E\u90E8\u95E8");
        label_3.setBounds(62, 136, 54, 15);
        contentPane.add(label_3);

        textField_3 = new JTextField();
        textField_3.setBounds(140, 133, 89, 21);
        contentPane.add(textField_3);
        textField_3.setColumns(10);

        JLabel label_4 = new JLabel("\u5DE5\u53F7");
        label_4.setBounds(62, 179, 54, 15);
        contentPane.add(label_4);

        textField_4 = new JTextField();
        textField_4.setBounds(140, 176, 89, 21);
        contentPane.add(textField_4);
        textField_4.setColumns(10);

        JLabel label_5 = new JLabel("\u5BC6\u7801");
        label_5.setBounds(62, 219, 54, 15);
        contentPane.add(label_5);

        textField_5 = new JTextField();
        textField_5.setBounds(140, 216, 89, 21);
        contentPane.add(textField_5);
        textField_5.setColumns(10);

        JButton button = new JButton("\u4FDD\u5B58");
        button.setBounds(277, 228, 66, 23);
        contentPane.add(button);

        JButton button_1 = new JButton("\u9000\u51FA");
        button_1.setBounds(358, 228, 66, 23);
        contentPane.add(button_1);

        button.addActionListener(this);
        button_1.addActionListener(this);

        show_textfiled(user_data);   //查询到的的用户信息显示到窗体上

        System.out.println("数据库返回查询序列如下：");
        for(int i=0;i<1;i++)
            for (int j=0;j<6;j++)
                System.out.print(user_data[i][j]+" ");
    }

    public void show_textfiled(String user_data[][]){
        System.out.println("查询的用户名："+username);
        user_data = sql_excute.search_by_username_all(username);
        textField.setText(user_data[0][0]);
        textField_1.setText(user_data[0][1]);
        textField_2.setText(user_data[0][2]);
        textField_3.setText(user_data[0][3]);
        textField_4.setText(user_data[0][4]);
        textField_5.setText(user_data[0][5]);
    }

    public void updata_user_data(){  //修改信息写回数据库
        user_data[0][0] = textField.getText();
        user_data[0][1] = textField_1.getText();
        user_data[0][2] = textField_2.getText();
        user_data[0][3] = textField_3.getText();
        user_data[0][4] = textField_4.getText();
        user_data[0][5] = textField_5.getText();

        sql_excute.updata_user_data(user_data);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "保存":
                updata_user_data();
                JOptionPane.showMessageDialog(null,user_data[0][0]+"的信息修改成功","修改提示",JOptionPane.INFORMATION_MESSAGE);
                //show_textfiled(user_data);
                break;
            case "退出":
                dispose();
                break;
        }
    }
}

