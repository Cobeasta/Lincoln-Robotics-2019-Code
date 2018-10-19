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
import org.firstinspires.ftc.teamcode.util.Constants;
import org.firstinspires.ftc.teamcode.util.Util;

public class Chassis extends Subsystem{
 private DcMotor leftDrive, rightDrive;
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
        setupGyro();
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
//        parameters.accelerationIntegrationAlgorithm = new BNO055IMU.AccelerationIntegrator() {
//            @Override
//            public void initialize(@NonNull BNO055IMU.Parameters parameters, @Nullable Position initialPosition, @Nullable Velocity initialVelocity) {
//
//            }
//
//            @Override
//            public Position getPosition() {
//                return null;
//            }
//
//            @Override
//            public Velocity getVelocity() {
//                return null;
//            }
//
//            @Override
//            public Acceleration getAcceleration() {
//                return null;
//            }
//
//            @Override
//            public void update(Acceleration linearAcceleration) {
//
//            }
//        }
        gyro = hardwaremap.get(BNO055IMU.class, "imu");
        gyro.initialize(parameters);


    }
    public void startGyro(){
        gyro.startAccelerationIntegration(new Position(), new Velocity(), 1000);

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
       rightDrive.setDirection(DcMotorSimple.Direction.REVERSE);

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
        tankDrive(gamepad1.left_stick_y, gamepad1.right_stick_y);
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
        s+= "Heading: " +gyro.getAngularOrientation().toString();
        s+= "Displacement: " + gyro.getPosition().toString();
        s += "Velocityy " + gyro.getVelocity().toString();
        return s;
    }


}
