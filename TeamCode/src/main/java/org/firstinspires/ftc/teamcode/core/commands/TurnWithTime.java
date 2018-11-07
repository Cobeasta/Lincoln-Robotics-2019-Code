package org.firstinspires.ftc.teamcode.core.commands;

import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.R;
import org.firstinspires.ftc.teamcode.core.Robot;
import org.firstinspires.ftc.teamcode.core.TimedCommand;
import org.firstinspires.ftc.teamcode.core.subsystems.Chassis;

public class TurnWithTime extends TimedCommand {
    private double left, right;
    //public long duration;

    // Added System.out.println to show when things are run. Helps in debugging

    public TurnWithTime(long time, double left, double right) {
        super(time);
        //this.duration = time;
        this.left = left;
        this.right = right;
        System.out.println("Checked TurnWithTime variables");
    }

    @Override
    public void initialize()
    {
        System.out.println("Initialized TurnWithTime");

        // TODO need to check that this is properly working with TimedCommand
//        Could be cross-referenced with DriveToDistance??
//        Can DriveToDistance be turned into a turn command??

        Robot.chassis.leftDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        Robot.chassis.rightDrive.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    @Override
    public void execute() {
        System.out.println("TurnWithTime is executed!!!");

        // TODO Seems to work, but only goes straight
        Robot.chassis.tankDrive(left, right);
    }

    @Override
    public void stop() {

        // Added just in case
        Robot.chassis.stop();
    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }
}
