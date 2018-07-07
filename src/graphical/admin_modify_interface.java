package graphical;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class admin_modify_interface extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTable table;

    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    admin_modify_interface frame = new admin_modify_interface();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    public admin_modify_interface() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 550, 370);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel("\u59D3\u540D");
        label.setBounds(10, 291, 54, 23);
        contentPane.add(label);

        textField = new JTextField();
        textField.setBounds(62, 291, 103, 26);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton button = new JButton("\u641C\u7D22");
        button.setBounds(198, 291, 68, 30);
        contentPane.add(button);

        JButton button_1 = new JButton("\u4FDD\u5B58");
        button_1.setBounds(320, 291, 68, 30);
        contentPane.add(button_1);

        JButton btnexcel = new JButton("\u9000\u51FA");
        btnexcel.setBounds(456, 291, 68, 30);
        btnexcel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        contentPane.add(btnexcel);

        JLabel label_1 = new JLabel("\u59D3\u540D");
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
    }
}
