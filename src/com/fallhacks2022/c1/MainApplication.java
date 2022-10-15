package com.fallhacks2022.c1;

import javax.swing.*;
import java.awt.*;

public class MainApplication {
    public JPanel PanelMain;

    public static TimerApplication app;

    public MainApplication() { }

    public static void main(String[] args)
    {
        app = new TimerApplication();
        app.StartTimerApplication();

        JFrame frame = new JFrame("Timer App");
        frame.setContentPane(app.PanelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(900, 600));

        frame.pack();
        frame.setVisible(true);
    }


}
