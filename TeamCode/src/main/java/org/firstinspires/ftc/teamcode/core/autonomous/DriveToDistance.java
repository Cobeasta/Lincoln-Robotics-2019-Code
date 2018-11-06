package org.firstinspires.ftc.teamcode.core.autonomous;

import org.firstinspires.ftc.teamcode.core.Auto;
import org.firstinspires.ftc.teamcode.core.Command;
import org.firstinspires.ftc.teamcode.core.Robot;

public class DriveToDistance extends Command {
    private int inches;
    public DriveToDistance(int inches)
    {
        this.inches = inches;
    }
    @Override
    public void initialize() {
        Robot.chassis.autoInit();
        Robot.chassis.setTargetPosition(inches);
    }

    @Override
    public void execute() {
        Robot.chassis.driveDistance();
    }

    @Override
    public void stop() {
        Robot.chassis.stop();
    }

    @Override
    public boolean isFinished() {
        return Robot.chassis.reachedDistance();
    }
}
