package graphical;

import sun.security.util.AuthResources_it;

import javax.jws.soap.SOAPBinding;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JFrame implements ActionListener {

    JLabel jlb1,jlb2;
    JPasswordField jpf;
    JTextField jtf;
    JButton jb1,jb2;

    public login(){
        //JPanel jp1,jp2;
        //jp1=new JPanel();


        jb1=new JButton();
        jb2=new JButton();
        jb1.setText("登陆");
        jb2.setText("取消");

        jlb1 = new JLabel();
        jlb2 = new JLabel();

        jpf = new JPasswordField();
        jtf = new JTextField();

        jlb1.setText("用户名:");
        jlb2.setText("密码:");
        jb1.addActionListener(this);
        jb2.addActionListener(this);

        this.add(jlb1);
        this.add(jlb2);
        this.add(jb2);
        this.add(jpf);
        this.add(jtf);
        this.add(jb1);
        this.add(jb2);
        this.setBounds(0,0,400,400);

        //this.add(jp1);
        this.setLayout(null);
        this.setTitle("please login");
        this.setResizable(false);

        this.setBounds(100,100,500,500);
        jlb1.setBounds(30,30,50,20);
        jlb2.setBounds(30,60,50,20);

        jtf.setBounds(100,30,100,20);
        jpf.setBounds(100,60,100,20);
        jb1.setBounds(110,90,80,50);
        jb2.setBounds(180,90,80,50);


        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setVisible(true);

        //move();
        //this.dispose();
        //return login_result;



    }

    public void move(){
        try{
            int i,j;
            for(i=0;i<1000;i++){
                for(j=0;j<500;j++)
                this.setLocation(i,j);
                Thread.sleep(10);
            }
        }catch(Exception e){

        }
    }

    public void actionPerformed(ActionEvent e){
        switch (e.getActionCommand()){
            case "登陆":
                String name = jtf.getText();
                String passwd = jpf.getText();

                sql_excute login = new sql_excute();  //调用数据库执行函数，判断数据库密码是否正确。
                boolean result = false;
                result = login.sql_connect(name,passwd);
                //System.out.println("判断结果："+result);
                if(result == true){
                    JOptionPane.showMessageDialog(null,"welcome back ! ","登陆提示",JOptionPane.INFORMATION_MESSAGE);
                    if(name.equals("admin")){
                        new admin_menu("主菜单","admin",1,0,10,10,500,500);
                        this.dispose();
                    }
                    else
                        //new user_menu();
                    //new start_interface();
                    this.dispose();
                }
                else
                    JOptionPane.showMessageDialog(null,"账号或密码错误,name = "+name+passwd,"登陆提示",JOptionPane.INFORMATION_MESSAGE);

                break;
            case "取消":
                JOptionPane.showMessageDialog(null,"点击了 取消","youngpark",JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }
}

