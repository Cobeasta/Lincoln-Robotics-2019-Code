package org.firstinspires.ftc.teamcode.util;

/**
 * Here, store the names for each of the motors in the hardware map,
 * store the pid constants for each of the loops,
 * and store any other constants that are used in the code.
 */
public class Constants {
    public static String elevatorMotor = "liftmotor";
    public static String intakeFlipper = "intakeflipper";
    public static String liftFlipper = "liftflipper";
    public static String intakeMotor = "intakemotor";
    public static String leftDrive = "leftdrive";
    public static String rightDrive = "rightdrive";
    public static String climber = "climber";
    public static double TICKS_TO_INCHES = 1;

    // Found 25000 to be the perfect amount of time for the climber to run IFF the climber is either at the very top and bottom.
    // Basically each is the place where the initialization takes place
    // topClimber is used as the amount of time to return to the bottom
    public static int topClimber = -25000;
    // bottomClimber is used as the amount of time to go to the top
    public static int bottomClimber= 25000;
    public static int landingNumber = 5000;
    public static int middleClimber = 0;

    /**
     * To wirelessly connect to phone,
     * plug in via USB]
     * In terminal use commands
     * adb devices
     * adb tcpip 5555
     * adb connect <IP address of phone>
     * adb disconnect <IP adress of phone>
     */
}
