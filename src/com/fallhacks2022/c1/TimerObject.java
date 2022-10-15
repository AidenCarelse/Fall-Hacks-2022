package com.fallhacks2022.c1;
import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;
import java.util.Timer;

public class TimerObject {

    public static void main(String[] args)
    {
        TimerObject obj = new TimerObject();
        obj.start();
    }

    int i = 100;
    Timer t = new Timer();
    TimerTask task = new TimerTask() {
        public void run() {
            i++;
            MainApplication.app.UpdateTimer(String.valueOf(i));
        }

    };

    public void start(){
        t.scheduleAtFixedRate(task,1000,1000);
    }
}

