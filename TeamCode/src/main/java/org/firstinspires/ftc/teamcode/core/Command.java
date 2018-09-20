package org.firstinspires.ftc.teamcode.core;

public abstract class Command {
    public boolean initialized = false;
    public boolean parallel = false;
    public abstract void init();
    public abstract void execute();
    public abstract void stop();
    public abstract boolean isFinished();
}
