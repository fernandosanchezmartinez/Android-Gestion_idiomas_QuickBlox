package com.example.lidiamartin.pmdm_lib.QBAdmin;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by lidia.martin on 06/11/2015.
 */
public class TasksAdmin extends TimerTask {
    private TasksAdminListener listener;
    private static long SPLASH_SCREEN_DELAY;
    private int iNumOfCycles;
    private Timer timer = null;

    public TasksAdmin(long delay, int numOfCycles) {
        SPLASH_SCREEN_DELAY = delay;
        iNumOfCycles = numOfCycles;
        timer = new Timer();
    }

    public void startTasks() {
        timer.schedule(this, SPLASH_SCREEN_DELAY, SPLASH_SCREEN_DELAY);
    }

    public void setTasksAdminListener(TasksAdminListener listener) {
        this.listener = listener;
    }

    @Override
    public void run() {
        if(listener!=null)listener.taskCycleFinished(iNumOfCycles);
        iNumOfCycles--;
        if(iNumOfCycles==0){
            timer.cancel();
            if(listener!=null)listener.taskCycleFinishedAll();
        }
    }
}
