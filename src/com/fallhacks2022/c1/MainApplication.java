package com.fallhacks2022.c1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApplication {
    private JButton ButtonTest;
    private JPanel PanelMain;

    public MainApplication() {
        ButtonTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hello World");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Timer App");
        frame.setContentPane(new MainApplication().PanelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(700, 700));
        frame.pack();
        frame.setVisible(true);
    }
}
