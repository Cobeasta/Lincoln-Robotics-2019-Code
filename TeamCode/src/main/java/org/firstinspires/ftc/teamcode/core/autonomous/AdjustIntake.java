package org.firstinspires.ftc.teamcode.core.autonomous;

import org.firstinspires.ftc.teamcode.core.Command;
import org.firstinspires.ftc.teamcode.core.Robot;

public class AdjustIntake extends Command {

    private int position;

    public AdjustIntake(int position){this.position = position;}
    @Override
    public void initialize() {
        Robot.intakeFlipper.autoInit();

    }

    @Override
    public void execute() {
        Robot.intakeFlipper.setTargetPosition(position);
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
