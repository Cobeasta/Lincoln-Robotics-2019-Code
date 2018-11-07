package org.firstinspires.ftc.teamcode.core.autonomous;

import org.firstinspires.ftc.teamcode.core.Command;

public class TurnToAngle extends Command{
    private double angle;
    public TurnToAngle(double angle)
    {
        this.angle = angle;
    }

    @Override
    public void initialize() {
        // TODO TurnToAngle would also be nice
    }

    @Override
    public void execute() {

    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
