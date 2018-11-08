package org.firstinspires.ftc.teamcode.core.commands;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.R;
import org.firstinspires.ftc.teamcode.core.Command;
import org.firstinspires.ftc.teamcode.core.Robot;
import org.firstinspires.ftc.teamcode.core.TimedCommand;
import org.firstinspires.ftc.teamcode.core.subsystems.Chassis;

import java.util.Date;

public class TurnWithTime extends Command {
    private double left, right;
    public long currTime, initTime;
    public int counter = 0;
    public double time;
    public ElapsedTime runtime = new ElapsedTime();

    // Added System.out.println to show when things are run. Helps in debugging

    public TurnWithTime(double time, double left, double right) {
        //super(time);
        this.time = time;
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

        initTime = new Date().getTime();
        System.out.println("Ran Timed Command init");
    }

    @Override
    public void execute() {
        System.out.println("TurnWithTime is executed!!!");

        // TODO Seems to work, but only goes straight
        //Robot.chassis.tankDrive(left, right);
        Robot.chassis.arcadeDrive(1,-1);
        //Robot.chassis.rightDrive.setPower(left);
        //Robot.chassis.rightDrive.setPower(right);
        counter++;
    }

    @Override
    public void stop() {

        // Added just in case
        Robot.chassis.stop();
    }

    @Override
    public boolean isFinished() {
        currTime = new Date().getTime();
        System.out.println("Ran Timed Command Finish");
        return (runtime.seconds()) > time;
    }
}
