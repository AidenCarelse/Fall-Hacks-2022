package com.fallhacks2022.c1;
import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;
import java.util.Timer;

public class TimerObject {

    int workMins, breakMins, longBreakMins, breakItervals;
    int currMins, currSeconds;

    Timer t = new Timer();
    TimerTask task = new TimerTask() {
        public void run() {
            if(currSeconds == 0)
            {
                currMins--;
                currSeconds = 60;
            }

            currSeconds--;

            if(currSeconds < 10) {
                MainApplication.app.UpdateTimer(currMins + " : 0" + currSeconds);
            }
            else
            {
                MainApplication.app.UpdateTimer(currMins + " : " + currSeconds);
            }
        }

    };

    public void pause(){
        t.cancel();


    }

    public void start(int workMins, int breakMins, int longBreakMins, int breakIntervals)
    {
        this.workMins = workMins;
        this.breakMins = breakMins;
        this.breakItervals = breakIntervals;
        this.longBreakMins = longBreakMins;
        currSeconds = 15;
        currMins = workMins;
        t.scheduleAtFixedRate(task,1000,1000);
    }
}

