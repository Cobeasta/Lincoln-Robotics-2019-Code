package org.firstinspires.ftc.teamcode.core.commands;

import org.firstinspires.ftc.teamcode.core.Command;
import org.firstinspires.ftc.teamcode.core.Robot;

public class RaiseLift extends Command {
    private boolean initialized = false;
    private int ticks;
    private boolean running = false;
    public RaiseLift(int ticks)
    {
        this.ticks = ticks;
        System.out.println("New Raise lift Command: Ticks = " + ticks);
    }
    @Override
    public void initialize() {
        initialized = true;
        Robot.climber.autoInit();
        Robot.climber.setTargetPosition(ticks);
        System.out.println(Robot.climber.motor.getCurrentPosition());
        System.out.println("Ran initialize");
    }

    @Override
    public void execute() {
        System.out.println("Lift Position: " + Robot.climber.getCurrentPosition());
        Robot.climber.runToPosition();

        if(!running) System.out.println("Climbing: ");

        running = true;
    }

    @Override
    public void stop() {
        Robot.climber.stop();

    }

    @Override
    public boolean isFinished() {
        System.out.println("Ran finished");
        return Robot.climber.reachedTargetPosition();

    }
    @Override
    public String toString(){
        return "Raise Lift Command Height: " + Robot.climber.getCurrentPosition()
                 + "\n ";
    }
}
