package org.firstinspires.ftc.teamcode.core.commands;

import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.core.Robot;
import org.firstinspires.ftc.teamcode.core.TimedCommand;

public class TurnWithTime extends TimedCommand {
    private double left, right;
    public TurnWithTime(long time, double left, double right) {
        super(time);
        this.left = left;
        this.right = right;
    }

    @Override
    public void initialize()
    {
        Robot.chassis.leftDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        Robot.chassis.rightDrive.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    @Override
    public void execute() {
        Robot.chassis.tankDrive(left, right);
    }

    @Override
    public void stop() {

    }
}
