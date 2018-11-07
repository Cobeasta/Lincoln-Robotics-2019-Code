package org.firstinspires.ftc.teamcode.core;

import java.util.Date;

public abstract class TimedCommand extends Command{
    protected long duration, initTime, currTime;
    public TimedCommand(long time){
        duration = time;
    }
    @Override
    public void init(){
        initTime = new Date().getTime();
        System.out.println("Ran Timed Command init");
        initialize();// Should call TurnWithTime's initialization method
    }
    public abstract void initialize();
        // Just here to be overridden. Seems weird


    @Override
    public boolean isFinished(){
        // Should be called in TurnWithTime.isFinished()
        currTime = new Date().getTime();
        System.out.println("Ran Timed Command Finish");
        return currTime - initTime > duration;
    }
}
