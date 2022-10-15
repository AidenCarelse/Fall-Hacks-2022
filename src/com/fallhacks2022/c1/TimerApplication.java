package com.fallhacks2022.c1;

import javax.swing.*;
import java.awt.*;

public class TimerApplication {

    private JLabel TimerLabel;
    public JPanel PanelMain;

    public void StartTimerApplication()
    {
        InitializeLabel();
    }

    private void InitializeLabel()
    {
        TimerLabel.setText("25:00");
        TimerLabel.setPreferredSize(new Dimension(100, 100));
    }

    public void UpdateTimer(String time)
    {
        TimerLabel.setText(time);
    }
}
