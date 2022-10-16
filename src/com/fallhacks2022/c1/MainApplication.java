package com.fallhacks2022.c1;

import javax.swing.*;
import java.awt.*;

//This class is the layout for the Java Application File
public class MainApplication {
    public JPanel PanelMain;

    public static TimerApplication app;

    public MainApplication() { }

    //The main method is responsible for determining the height and width of the Java Application UI
    public static void main(String[] args)
    {
        app = new TimerApplication();
        app.StartTimerApplication();

        JFrame frame = new JFrame("Timer App");
        frame.setContentPane(app.PanelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(900, 600));

        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }


}
