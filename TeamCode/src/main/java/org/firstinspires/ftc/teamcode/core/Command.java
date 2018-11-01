package org.firstinspires.ftc.teamcode.core;


import java.util.Date;

public abstract class Command {
    public boolean initialized = false;
    public boolean parallel = false;

    public void init()
    {
        this.initialize();
    }

    public abstract void initialize();
    public abstract void execute();
    public abstract void stop();
    public abstract boolean isFinished();
}
