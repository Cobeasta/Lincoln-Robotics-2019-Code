package org.firstinspires.ftc.teamcode.core.autonomous;

import org.firstinspires.ftc.teamcode.core.Command;
import org.firstinspires.ftc.teamcode.core.Robot;

public class RaiseLift extends Command {
    private int ticks;
    public RaiseLift(int ticks)
    {
        this.ticks = ticks;
    }
    @Override
    public void initialize() {
        Robot.climber.autoInit();
        Robot.climber.setTargetPosition(ticks);
    }

    @Override
    public void execute() {
        Robot.climber.runToPosition();

    }

    @Override
    public void stop() {
        Robot.climber.stop();

    }

    @Override
    public boolean isFinished() {
        return Robot.climber.reachedTargetPosition();
    }
}
