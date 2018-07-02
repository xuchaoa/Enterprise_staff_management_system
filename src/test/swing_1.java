package test;

import javax.swing.*;


public class swing_1 {
    public static void main(String arg[]){
        JFrame main_windows = new JFrame("title");
        main_windows.setBounds(500,200,800,800);
        main_windows.setVisible(true);
        main_windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
