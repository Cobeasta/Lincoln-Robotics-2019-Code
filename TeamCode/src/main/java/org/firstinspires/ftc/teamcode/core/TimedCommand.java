package org.firstinspires.ftc.teamcode.core;

import java.util.Date;
import java.util.Timer;

public abstract class TimedCommand extends Command{
    protected long duration, initTime, currTime;
    public TimedCommand(long time){
        duration = time;
    }
    @Override
    public void init(){
        initTime = new Date().getTime();
    }
    public abstract void initialize();



    @Override
    public boolean isFinished(){
            currTime = new Date().getTime();
            return currTime - initTime > duration;
    }
}
