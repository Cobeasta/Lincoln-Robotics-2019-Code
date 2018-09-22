package org.firstinspires.ftc.teamcode.core;

import java.util.Timer;

public abstract class TimedCommand extends Command{
    protected long duration, initTime;
    public TimedCommand(long time){
        duration = time;
    }
    @Override
    public void init(){
        initTime = System.currentTimeMillis();
    }
    public abstract void initialize();



    @Override
    public boolean isFinished(){
            return System.currentTimeMillis() - initTime >= duration;
    }
}
