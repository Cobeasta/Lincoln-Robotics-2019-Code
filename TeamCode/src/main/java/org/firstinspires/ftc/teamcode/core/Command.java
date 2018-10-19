package org.firstinspires.ftc.teamcode.core;


import java.util.Date;

public abstract class Command {
    protected Date startTime;
    private double runTime = 0;
    public boolean initialized = false;
    public boolean parallel = false;

    public void init()
    {

    }

    public abstract void initialize();
    public abstract void execute();
    public abstract void stop();
    public abstract boolean isFinished();
}
