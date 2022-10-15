package com.fallhacks2022.c1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class TimerApplication {

    private JLabel TimerLabel;
    public JPanel PanelMain;
    private JButton StartButton;
    private JButton PauseButton;
    private JLabel WorkTime;
    private JLabel BreakTime;

    public void StartTimerApplication()
    {
        PanelMain.setLayout(null);

        InitializeLabel();
        InitializeButtons();
        InitializeTimes();
        InitializeTabs();
    }

    private void InitializeLabel()
    {
        TimerLabel = new JLabel("25 : 00", SwingConstants.CENTER);
        PanelMain.add(TimerLabel);

        TimerLabel.setBounds(75, 125,400, 100);
        TimerLabel.setFont(new Font("SansSerif", Font.BOLD, 100));
    }

    private void InitializeButtons()
    {
        StartButton = new JButton();
        PauseButton = new JButton();
        PanelMain.add(StartButton);
        PanelMain.add(PauseButton);

        StartButton.setBounds(115,TimerLabel.getY() + TimerLabel.getHeight() + 30, 150, 35);
        PauseButton.setBounds(285,TimerLabel.getY() + TimerLabel.getHeight() + 30, 150, 35);

        StartButton.setText("START");
        PauseButton.setText("PAUSE");
        StartButton.setFont(new Font("SansSerif", Font.BOLD, 24));
        PauseButton.setFont(new Font("SansSerif", Font.BOLD, 24));

        StartButton.setForeground(Color.white);
        PauseButton.setForeground(Color.white);
        StartButton.setBackground(new Color(237, 92, 78));
        PauseButton.setBackground(new Color(237, 92, 78));

        StartButton.setFocusPainted(false);
        PauseButton.setFocusPainted(false);
        StartButton.setBorder(null);
        PauseButton.setBorder(null);

        StartButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // Start timer
            }
        });
        PauseButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // Pause/stop timer
            }
        });
    }

    private void InitializeTimes()
    {
        WorkTime = new JLabel("Total Time Worked 00:00", SwingConstants.CENTER);
        BreakTime = new JLabel("Total Break Time 00:00", SwingConstants.CENTER);
        PanelMain.add(WorkTime);
        PanelMain.add(BreakTime);

        WorkTime.setBounds(StartButton.getX(), StartButton.getY() + StartButton.getHeight(),  150, 20);
        BreakTime.setBounds(PauseButton.getX(), PauseButton.getY() + PauseButton.getHeight(), 150, 20);

        WorkTime.setForeground(Color.gray);
        BreakTime.setForeground(Color.gray);
    }

    private void InitializeTabs()
    {
        JTabbedPane tabbedPane = new JTabbedPane();
        PanelMain.add(tabbedPane);

        tabbedPane.setBounds(550, 0, 300, 500);
        tabbedPane.setFont(new Font("SansSerif", Font.PLAIN, 14));
        tabbedPane.setBorder(null);

        tabbedPane.addTab("Tasks", InitializeToDoList());
        tabbedPane.addTab("Completed", InitializeCompletedList());
        tabbedPane.add("+", InitializeAddList());
    }

    private JPanel InitializeToDoList()
    {
        JPanel todo = new JPanel(null);

        todo.setBackground(Color.white);

        //JCheckBox test = new JCheckBox();
        //test.setBounds(10, 10, 100, 20);
        //todo.add(test);

        JLabel empty = new JLabel("<html>You don't have any tasks, click + to create<br/>one!</html>");
        empty.setFont(new Font("SansSerif", Font.ITALIC, 14));
        empty.setForeground(Color.gray);
        empty.setBounds(10, 10, 290, 40);
        todo.add(empty);

        return todo;
    }

    private JPanel InitializeCompletedList()
    {
        JPanel completed = new JPanel(null);

        return completed;
    }

    private JPanel InitializeAddList()
    {
        JPanel addPanel = new JPanel(null);
        addPanel.setBackground(Color.white);
        addPanel.setBorder(null);

        JTextField test = new JTextField ();
        test.setBounds(10, 10, 250, 25);
        test.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JButton add = new JButton();
        add.setBounds(10, test.getY() + test.getHeight() + 5, 100, 20);
        add.setFont(new Font("SansSerif", Font.BOLD, 14));
        add.setText("Add Task");
        add.setBorder(null);
        add.setForeground(Color.white);
        add.setBackground(new Color(237, 92, 78));

        addPanel.add(test);
        addPanel.add(add);
        return addPanel;
    }

    public void UpdateTimer(String time)
    {
        TimerLabel.setText(time);
    }
}

