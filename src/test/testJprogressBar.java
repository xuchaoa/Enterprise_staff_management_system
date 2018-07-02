package test;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class testJprogressBar extends JFrame
{
    JProgressBar bar;
    JPanel panel;

    private testJprogressBar()
    {
        bar = new JProgressBar(SwingConstants.VERTICAL);// 设置垂直方向
        // bar.setSize(30, 30);// 不能修改大小
        bar.setMaximum(100);// 设置最大值
        bar.setMinimum(0);// 设置最小值
        bar.setValue(20);// 设置进度条当前值
        this.setSize(200, 200);

        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        bar.setPreferredSize(new Dimension(30, 50));
        panel.add(bar);
        this.add(panel, BorderLayout.CENTER);
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {

            @Override
            public void run()
            {
                new testJprogressBar();
            }
        });
    }
}