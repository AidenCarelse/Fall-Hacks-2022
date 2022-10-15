package com.fallhacks2022.c1;
import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;
import java.util.Timer;

public class TimerObject {

    int workMins, breakMins, longBreakMins, breakIntervals;
    int currMins, currSeconds, breakSeconds, restMins, restSeconds;
    Timer t;



    public void pause(){
        t.cancel();


    }

    public void start(int workMins, int breakMins, int longBreakMins, int breakIntervals, boolean resume)
    {
        if(!resume)
        {
            this.workMins = workMins;
            this.breakMins = breakMins;
            this.breakIntervals = breakIntervals;
            this.longBreakMins = longBreakMins;
            currSeconds = 0;
            currMins = workMins;
            breakSeconds=0;
            restMins = breakMins;


        }

        t = new Timer();


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

                if(currMins == 0 && currSeconds == 0)
                {
                   currMins = breakMins;
                }
            }
            public void breaks(){
                if(currMins == 0 && currSeconds==0){


                }

            }

        };
        t.scheduleAtFixedRate(task,1000,1000);
    }
}

