package com.fallhacks2022.c1;

import javax.swing.*;
import java.awt.*;

public class MainApplication {
    public JPanel PanelMain;

    public MainApplication() { }

    public static void main(String[] args)
    {
        TimerApplication app = new TimerApplication();
        app.StartTimerApplication();

        JFrame frame = new JFrame("Timer App");
        frame.setContentPane(app.PanelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(700, 700));

        frame.pack();
        frame.setVisible(true);
    }


}
