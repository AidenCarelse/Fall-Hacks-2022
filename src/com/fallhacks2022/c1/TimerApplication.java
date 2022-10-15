package com.fallhacks2022.c1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class TimerApplication {

    private JLabel TimerLabel;
    public JPanel PanelMain;
    private JButton StartButton;
    private JButton PauseButton;
    private JLabel WorkTime;
    private JLabel BreakTime;
    private java.util.List<String> tasks;
    private JPanel todoPanel;
    private JTabbedPane tabbedPane;
    private JLabel empty;
    private JTextField field;
    private TimerObject timer = null;

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
                boolean resume = true;

                if(timer == null)
                {
                    timer = new TimerObject();
                    resume = false;
                }

                timer.start(25, 5, 25, 4, resume);
            }
        });
        PauseButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                timer.pause();
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
        tabbedPane = new JTabbedPane();
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
        todoPanel = new JPanel(null);

        todoPanel.setBackground(Color.white);

        empty = new JLabel("<html>You don't have any tasks, click + to create<br/>one!</html>");
        empty.setFont(new Font("SansSerif", Font.ITALIC, 14));
        empty.setForeground(Color.gray);
        empty.setBounds(10, 10, 290, 40);
        todoPanel.add(empty);

        return todoPanel;
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

        field = new JTextField ();
        field.setBounds(10, 10, 250, 25);
        field.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JButton add = new JButton();
        add.setBounds(10, field.getY() + field.getHeight() + 5, 100, 20);
        add.setFont(new Font("SansSerif", Font.BOLD, 14));
        add.setText("Add Task");
        add.setBorder(null);
        add.setForeground(Color.white);
        add.setBackground(new Color(237, 92, 78));

        add.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                AddToToDoList(field.getText());
            }
        });

        tasks = new ArrayList<String>();

        addPanel.add(field);
        addPanel.add(add);
        return addPanel;
    }

    private void AddToToDoList(String task)
    {
        tasks.add(task);
        int y = 10;

        if(tasks.size() == 1)
        {
            todoPanel.remove(empty);
        }
        else
        {
            Component last = todoPanel.getComponents()[todoPanel.getComponents().length - 1];
            y = last.getY() + last.getHeight();
        }

        JCheckBox check = new JCheckBox();
        check.setBounds(10, y, 20, 30);
        check.setBackground(Color.white);

        JLabel label = new JLabel(task);
        label.setFont(new Font("SansSerif", Font.PLAIN, 14));
        label.setForeground(Color.gray);
        label.setBounds(35, y, 290, 30);

        check.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                RemoveFromToDoList(check, label);
            }
        });


        todoPanel.add(label);
        todoPanel.add(check);
        tabbedPane.setSelectedComponent(todoPanel);
        field.setText("");
    }

    private void RemoveFromToDoList(JCheckBox checkBox, JLabel label)
    {
        todoPanel.remove(checkBox);
        todoPanel.remove(label);

        todoPanel.revalidate();
        todoPanel.repaint();
    }

    public void UpdateTimer(String time)
    {
        TimerLabel.setText(time);
    }
}

