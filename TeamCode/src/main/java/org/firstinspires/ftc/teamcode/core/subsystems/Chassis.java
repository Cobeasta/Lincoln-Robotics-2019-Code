package org.firstinspires.ftc.teamcode.core.subsystems;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.hardware.bosch.NaiveAccelerationIntegrator;
import com.qualcomm.hardware.motors.RevRoboticsHdHexMotor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;
import org.firstinspires.ftc.teamcode.core.Robot;
import org.firstinspires.ftc.teamcode.util.Constants;
import org.firstinspires.ftc.teamcode.util.Util;

public class Chassis extends Subsystem{
 public DcMotor leftDrive, rightDrive;
 int constru = 0;
 BNO055IMU gyro;

    /**
     * The drive line system for our robot.
     * It is a 6 wheel drop center powered by REV's hex motors.
     * It also contains the gyroscope.
     * @param hw
     */
   public Chassis(HardwareMap hw){

       super(hw);
        leftDrive = hardwaremap.dcMotor.get(Constants.leftDrive);
        rightDrive =hardwaremap.dcMotor.get(Constants.rightDrive);
        leftDrive.setDirection(DcMotorSimple.Direction.REVERSE);
       rightDrive.setDirection(DcMotorSimple.Direction.FORWARD);
        constru++;
        leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        gyro = (BNO055IMU) hardwaremap.get("gyro");
      // setupGyro();
   }

    /**
     * Setup gyro. This initializes the gyroscope to use degrees,
     */
    private void setupGyro()
    {
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit           = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode
        parameters.loggingEnabled      = true;
        parameters.loggingTag          = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();

        gyro = hardwaremap.get(BNO055IMU.class, "imu");
        gyro.initialize(parameters);


    }
    public void startGyro(){
    //    gyro.startAccelerationIntegration(new Position(), new Velocity(), 1000);

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
    public void startAccelerationIntegration(){
        gyro.startAccelerationIntegration(null,null, 250);
    }

    /**
     * Drives the robot with a basic tank drive.
     * @param gamepad1
     * @param  gamepad2
     */
    @Override
    public void teleopControls(Gamepad gamepad1, Gamepad gamepad2)
    {

        tankDrive(-gamepad1.left_stick_y, -gamepad1.right_stick_y);
    }

    /**
     * Sets power to motors to zero. Always call when done using this class for safety.
     */
    @Override
    public void stop(){
        leftDrive.setPower(0);
        rightDrive.setPower(0);
    }

    /**
     * Called during op modes to provide information aobut this subsystem.
     * @return Returns the text to add to the bottom of the  driver station.
     */
    @Override
    public String addTelemetry()
    {
        String s = "Chassis \n";
//        s+= "[Left Drive]" + leftDrive.toString() + "\t[Right Drive: " +rightDrive.toString();
     //   s+= "Heading: " +gyro.getAngularOrientation().toString();
//        s+= "Displacement: " + gyro.getPosition().toString();
        s += "Velocity " + gyro.getVelocity().toString();
        s += "left drive reversed: " + leftDrive.getDirection() +"\n";
        s += "rightDrive reversed: " +rightDrive.getDirection();
        s+= "Left Drive Position: " +leftDrive.getCurrentPosition() +"\n";
        s += "Right Drive Position: " + rightDrive.getCurrentPosition()+"\n";
        s+= "constructor ran #: " + constru;

        return s;
    }
    public String toString(){
        String s = "Chassis \n";
//        s+= "[Left Drive]" + leftDrive.toString() + "\t[Right Drive: " +rightDrive.toString();
//        s+= "Heading: " +gyro.getAngularOrientation().toString();
//        s+= "Displacement: " + gyro.getPosition().toString();
//        s += "Velocity " + gyro.getVelocity().toString();
        s += "left drive reversed: " + leftDrive.getDirection() +"\n";
        s += "rightDrive reversed: " +rightDrive.getDirection();
        s+= "Left Drive Position: " +leftDrive.getCurrentPosition() +"\n";
        s += "Right Drive Position: " + rightDrive.getCurrentPosition()+"\n";
        s+= "constructor ran #: " + constru;
        return s;
    }

    /**
     *Sets the runmode of the encoders to not use encoders.
     */
    @Override
    public void teleopInit(){
        leftDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }
    public void reset()
    {
        leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    /**
     *
     */
    public void autoInit(){
        leftDrive.setDirection(DcMotorSimple.Direction.FORWARD);
        leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }

    public void driveDistance(){

        leftDrive.setPower(1);
        rightDrive.setPower(1);
    }
    public boolean reachedDistance(){
        return Math.abs(leftDrive.getCurrentPosition() - leftDrive.getTargetPosition()) < 50;

    }

    /**
     * Sets the target position of the  motors.
     * @precondition autoInit must be called
     * @postcondition driveDistance must be called
     * @param ticks
     */
    public void setTargetPosition(int ticks){
        ticks *= Constants.TICKS_TO_INCHES;
        leftDrive.setTargetPosition(( leftDrive.getCurrentPosition()-ticks));
        rightDrive.setTargetPosition((ticks + rightDrive.getCurrentPosition()));
    }
    public int getLeftCurrentPosition(){
        return leftDrive.getCurrentPosition();
    }
    public int getRightCurrentPosition()
    {
        return rightDrive.getCurrentPosition();
    }
    public int getLeftTargetPositioni()
    {
        return leftDrive.getTargetPosition();
    }
    public int getRightTargetPosition()
    {
        return rightDrive.getTargetPosition();
    }
}
