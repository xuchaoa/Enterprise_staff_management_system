package graphical;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class register extends JFrame implements ActionListener {
    JLabel user_id_label,au_id_label,department_id_label,name_label,sex_label,age_label;
    JPasswordField passwd;
    JTextField user_id_text,au_id_text,department_id_text,name_text,sex_text,age_text,passwd_text;
    JButton register,cancel;
    public void user_register(){
        //user_id_label = new JLabel();  //所有标签实例化
//        au_id_label = new JLabel();
//        department_id_label = new JLabel();
//        name_label = new JLabel();
//        sex_label = new JLabel();
//        age_label = new JLabel();
//        passwd = new JPasswordField();
//
//        user_id_text = new JTextField();
//        au_id_text = new JTextField();
//        department_id_text = new JTextField();
//        name_text = new JTextField();
//        sex_text = new JTextField();
//        age_text = new JTextField();
//        passwd_text = new JTextField();
//
//        register = new JButton();
//        cancel = new JButton();
//        register.setText("录入");
//        cancel.setText("取消");
//
//        register.addActionListener(this);//加入监听器
//        cancel.addActionListener(this);
//
//        //user_id_label.setText("");
//        au_id_label.setText("权限id");
//        department_id_label.setText("部门编号");
//        name_label.setText("姓名");
//        sex_label.setText("性别");
//        age_label.setText("年龄");
//        passwd.setText("密码");
//
//        this.add(au_id_label);
//        this.add(department_id_label);
//        this.add(name_label);
//        this.add(sex_label);
//        this.add(age_label);
//        this.add(passwd);
//        this.add(register);
//        this.add(cancel);
//        this.add(au_id_text);
//        this.add(department_id_text);
//        this.add(name_text);
//        this.add(sex_text);
//        this.add(age_text);
//        this.add(passwd_text);


        //this.setLayout(null);
        this.setTitle("信息录入");
       // this.setResizable(true);
        //this.setBounds(100,100,500,500);

this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
