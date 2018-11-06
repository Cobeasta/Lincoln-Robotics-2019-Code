package org.firstinspires.ftc.teamcode.core.commands;

import org.firstinspires.ftc.teamcode.core.Command;
import org.firstinspires.ftc.teamcode.core.Robot;

public class RaiseLift extends Command {
    private boolean initialized = false;
    private int distance;
    private boolean running = false;
    public RaiseLift(int ticks)
    {
        this.distance = ticks;
        System.out.println("New Raise lift Command: Ticks = " + ticks);
    }
    @Override
    public void initialize() {
        initialized = true;
        Robot.climber.autoInit();
        Robot.climber.setTargetPosition(distance);
    }

    @Override
    public void execute() {
        System.out.println("Lift Position: " + Robot.climber.motor.getCurrentPosition());
        Robot.climber.runToPosition();

        if(running != true) System.out.println("Climbing: ");

        running = true;
    }

    @Override
    public void stop() {
        Robot.climber.stop();

    }

    @Override
    public boolean isFinished() {

        return Robot.climber.reachedTargetPosition();
    }
    @Override
    public String toString(){
        return "Raise Lift Command Height: " + Robot.climber.getCurrentPosition()
                 + "\n ";
    }
}
