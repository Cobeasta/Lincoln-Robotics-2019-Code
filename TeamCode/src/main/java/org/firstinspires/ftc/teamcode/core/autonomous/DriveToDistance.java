package org.firstinspires.ftc.teamcode.core.autonomous;

import org.firstinspires.ftc.teamcode.core.Auto;
import org.firstinspires.ftc.teamcode.core.Command;
import org.firstinspires.ftc.teamcode.core.Robot;
import org.firstinspires.ftc.teamcode.util.Constants;

public class DriveToDistance extends Command {
    private int inches;
    public DriveToDistance(int inches)
    {
        this.inches = inches;
    }
    @Override
    public void initialize() {
        Robot.chassis.autoInit();
        Robot.chassis.setTargetPosition((int) (inches));
        int rightInitialPosition = Robot.chassis.getRightCurrentPosition();
        int leftInitialPosition = Robot.chassis.getLeftCurrentPosition();
        System.out.println("Left Initial Position: " + leftInitialPosition);
        System.out.println("Left Target Position: " + Robot.chassis.getLeftTargetPositioni());
        System.out.println("Right initial Position: "+rightInitialPosition);
        System.out.println("Right Target Position: " + Robot.chassis.getRightTargetPosition());

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
    @Override
    public String toString(){
        return "Encoder Drive Command:  " +inches;
    }
}
