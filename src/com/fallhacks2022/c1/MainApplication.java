package com.fallhacks2022.c1;

import javax.swing.*;
import java.awt.*;

public class MainApplication {
    private JPanel PanelMain;
    private JLabel TimerLabel;

    public MainApplication() {

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Timer App");
        frame.setContentPane(new MainApplication().PanelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(700, 700));
        frame.pack();
        frame.setVisible(true);
    }

    public void UpdateTimer(String time)
    {
        TimerLabel.setText(time);
    }
}
