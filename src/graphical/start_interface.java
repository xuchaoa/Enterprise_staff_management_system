package graphical;


import javax.swing.*;
import java.awt.*;
import java.io.*;

public class start_interface extends JFrame {
    public start_interface(){

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Already there
        //this.setExtendedState(JFrame.DISPOSE_ON_CLOSE);
        this.setUndecorated(true);

        this.setLayout(null);

        JLabel jb1 =new JLabel();
        ImageIcon img = new ImageIcon("./src/2.jpg");
        jb1.setIcon(img);
        JLabel jb2 = new JLabel("企业员工管理系统");


        this.add(jb2);
        this.add(jb1);

        this.setBounds(500,500,700,500);
        jb1.setBounds(50,10,561,300);
        jb2.setBounds(150,300,400,130);

        //jb2.setForeground(Color.RED);
        jb2.setFont(new Font("楷体", Font.BOLD, 40));

        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        try{
            Thread.sleep(2500);
        }catch (Exception E){

        }
        dispose();
    }


}
