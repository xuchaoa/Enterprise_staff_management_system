package graphical;



import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.String;

public class register extends JFrame implements ActionListener {
    Box BaseBox,box,Box1,Box2,box1,box2,box3,box4;
    JLabel user_id_label,au_id_label,department_id_label,name_label,sex_label,age_label,passwd_lable;
    JPasswordField passwd;
    JTextField user_id_text,au_id_text,department_id_text,name_text,sex_text,age_text;
    JButton register,cancel;
    public register(){
        inituser_register();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("信息录入");
        setResizable(false);
        this.setBounds(670,300,600,470);
    }
    public void inituser_register(){
        setLayout(new FlowLayout());
        au_id_label = new JLabel();                    //标签声明
        department_id_label = new JLabel();
        name_label = new JLabel();
        sex_label = new JLabel();
        age_label = new JLabel();
        passwd_lable= new JLabel();

        //user_id_text = new JTextField(10);
        au_id_text = new JTextField(10);
        department_id_text = new JTextField(10);
        name_text = new JTextField(10);
        sex_text = new JTextField(10);
        age_text = new JTextField(10);
        passwd = new JPasswordField(10);




        register = new JButton();              //按钮声明
        cancel = new JButton();
        register.setText("录入");
        cancel.setText("取消");



        register.addActionListener(this);   //加入监听器
        cancel.addActionListener(this);

        BaseBox = Box.createVerticalBox();   //盒子布局  最外层大盒子上下两个 行式大盒子，上半部分 嵌套4个列式小盒子，下半部分潜逃两个按钮
        Box1 = Box.createHorizontalBox();
        Box2 = Box.createHorizontalBox();
        box1 = Box.createVerticalBox();
        box2 = Box.createVerticalBox();
        box3 = Box.createVerticalBox();
        box4 = Box.createVerticalBox();

        au_id_label.setText("权    限 id:");         //标签命名
        department_id_label.setText("部门编号:");
        name_label.setText("姓     名:");
        sex_label.setText("性      别:");
        age_label.setText("年      龄:");
        passwd_lable.setText("密      码:");




        box1.add(Box.createVerticalStrut(40));
        box1.add(au_id_label);
        box1.add(Box.createVerticalStrut(28));

        box1.add(department_id_label);
        box1.add(Box.createVerticalStrut(28));

        box1.add(name_label);
        box1.add(Box.createVerticalStrut(28));

        box1.add(sex_label);
        box1.add(Box.createVerticalStrut(28));

        box1.add(age_label);
        box1.add(Box.createVerticalStrut(28));

        box1.add(passwd_lable);
        box1.add(Box.createVerticalStrut(28));

        box3.add(Box.createHorizontalStrut(30));

        box2.add(Box.createVerticalStrut(40));
        box2.add(au_id_text);
        box2.add(Box.createVerticalStrut(23));

        box2.add(department_id_text);
        box2.add(Box.createVerticalStrut(20));

        box2.add(name_text);
        box2.add(Box.createVerticalStrut(20));

        box2.add(sex_text);
        box2.add(Box.createVerticalStrut(20));

        box2.add(age_text);
        box2.add(Box.createVerticalStrut(20));

        box2.add(passwd);
        box2.add(Box.createVerticalStrut(20));


        Box2.add(register);

        Box2.add(box4);
        Box2.add(Box.createHorizontalStrut(30));

        Box2.add(Box.createVerticalStrut(50));
        Box2.add(cancel);
        Box2.add(Box.createHorizontalStrut(14));   //cancel距离外盒的距离

        Box1.add(box1);
        Box1.add(box3);
        Box1.add(box2);

        //  Box2.add();
        BaseBox.add(Box1);
        BaseBox.add(Box2);
        add(BaseBox);
        this.setResizable(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //String  user_id_text
        String au_id = au_id_text.getText();
        String department_id = department_id_text.getText();
        String name = name_text.getText();
        String sex = sex_text.getText();
        String age = age_text.getText();
        String password = passwd.getText();



        System.out.println("获取到的数据字符串："+au_id+department_id+name+sex+age+password);
        switch (e.getActionCommand()){
            case "录入":
                if (au_id != null && au_id.length()!=0 && department_id != null && department_id.length()!=0 && name != null && name.length() != 0 && sex != null && sex.length()!=0 && age != null && age.length() != 0 && password != null && password.length() != 0){
                    sql_excute.register(au_id,department_id,name,sex,age,password);
                    sql_excute.inertinto_authority(au_id);
                    sql_excute.inertinto_department(department_id);
                    JOptionPane.showMessageDialog(null,"录入成功","登陆提示",JOptionPane.INFORMATION_MESSAGE);


                }else {
                    JOptionPane.showMessageDialog(null,"信息不能为空","录入提示",JOptionPane.WARNING_MESSAGE);
                }

                break;
            case "取消":
                dispose();
                break;

        }
    }
}





