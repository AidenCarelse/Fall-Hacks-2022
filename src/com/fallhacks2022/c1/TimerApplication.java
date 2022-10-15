package com.fallhacks2022.c1;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
    public JLabel session;

    public void StartTimerApplication()
    {
        PanelMain.setLayout(null);

        try
        {
            SetWaves();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        SetTitle();
        InitializeLabel();
        InitializeButtons();
        InitializeTimes();
        InitializeTabs();
    }

    private void SetWaves() throws IOException
    {
        Image bottomWaves = ImageIO.read(new File("svg_wave_bottom.png")).getScaledInstance(900, 125, Image.SCALE_DEFAULT);
        JLabel picture = new JLabel(new ImageIcon(bottomWaves));
        picture.setBounds(0, 450, 900, 125);
        PanelMain.add(picture);
    }

    private void SetTitle()
    {
        JLabel title = new JLabel("The Pomodoro Technique", SwingConstants.LEFT);
        PanelMain.add(title);

        title.setBounds(25, 25, 500, 30);
        title.setFont(new Font("SansSerif", Font.BOLD, 32));

        JLabel subtitle = new JLabel("Study Clock & Check List");
        PanelMain.add(subtitle);
        subtitle.setBounds(25, title.getY() + title.getHeight() + 10, 500, 30);
        subtitle.setFont(new Font("SansSerif", Font.BOLD, 20));
        subtitle.setForeground(Color.gray);
    }

    private void InitializeLabel()
    {
        TimerLabel = new JLabel("25 : 00", SwingConstants.CENTER);
        PanelMain.add(TimerLabel);

        TimerLabel.setBounds(75, 175,400, 100);
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

                timer.start(1, 2, 25, 4, resume);
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
        session = new JLabel("Working Time!", SwingConstants.CENTER);
        PanelMain.add(session);

        session.setBounds(TimerLabel.getX(), TimerLabel.getY() - 30, TimerLabel.getWidth(), 30);
        session.setFont(new Font("SansSerif", Font.BOLD, 18));
        session.setForeground(Color.gray);

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

        tabbedPane.setBounds(550, 0, 300, 475);
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
        completed.setBackground(Color.white);

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
        check.setForeground(Color.white);

        JLabel label = new JLabel(task);
        label.setFont(new Font("SansSerif", Font.PLAIN, 14));
        label.setForeground(Color.gray);
        label.setBounds(35, y, 290, 30);

        check.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    RemoveFromToDoList(check, label);
                }
                catch (InterruptedException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        });


        todoPanel.add(label);
        todoPanel.add(check);
        tabbedPane.setSelectedComponent(todoPanel);
        field.setText("");
    }

    private void RemoveFromToDoList(JCheckBox checkBox, JLabel label) throws InterruptedException
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

    public void UpdateSessionText(boolean working)
    {
        if(working)
        {
            session.setText("Working Time!");
        }
        else
        {
            session.setText("Break Time!");
        }
    }
}

