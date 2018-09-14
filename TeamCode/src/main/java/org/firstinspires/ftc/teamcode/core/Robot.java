package org.firstinspires.ftc.teamcode.core;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.core.core.subsystems.Chassis;

/**
 * This class will store static instances of each of the modules.
 */
public class Robot{
    public static Chassis chassis;

//Store hardware as static variables. at the top.
public Robot(HardwareMap hwMap)
{
 chassis = new Chassis(hwMap);

}


}
