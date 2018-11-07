package org.firstinspires.ftc.teamcode.core.autonomous;

import org.firstinspires.ftc.teamcode.core.Command;
import org.firstinspires.ftc.teamcode.core.Robot;

public class AdjustLiftFlipper extends Command {

    private int position;

    public AdjustLiftFlipper(int position){this.position = position;}
    @Override
    public void initialize() {
        Robot.liftFlipper.autoInit();

    }

    @Override
    public void execute() {
        Robot.liftFlipper.setTargetPosition(position);
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
