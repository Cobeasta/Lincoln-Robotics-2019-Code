package org.firstinspires.ftc.teamcode.core.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.util.Util;

public class Chassis extends Subsystem{
 private DcMotor leftDrive, rightDrive;

   public Chassis(HardwareMap hw){
       super(hw);
        leftDrive = hardwaremap.dcMotor.get("left_drive");
        rightDrive =hardwaremap.dcMotor.get("right_drive");

    }

    /**
     * Set raw power to each motor.
     * @param leftPower -1 to 1
     * @param rightPower -1 to 1
     */
    public void tankDrive(double leftPower, double rightPower)
    {
       leftDrive.setPower(leftPower);
       rightDrive.setPower(rightPower);

    }

    /**
     * Have the robot drive based off of magnitude and direction to control turning and driving.
     * @param power
     * @param turn
     */
    public void arcadeDrive(double power, double turn)
    {
       leftDrive.setPower(Util.trim(power + turn, -1, 1));
       rightDrive.setPower(Util.trim(power - turn, -1, 1));

    }

    /**
     * Drives the robot with a basic tank drive.
     * @param gamepad1
     * @param  gamepad2
     */
    @Override
    public void teleopControls(Gamepad gamepad1, Gamepad gamepad2)
    {
        tankDrive(gamepad1.left_stick_y, gamepad1.right_stick_y);
    }
    @Override
    public void stop(){
        leftDrive.setPower(0);
        rightDrive.setPower(0);
    }
}
