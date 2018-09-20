package org.firstinspires.ftc.teamcode.core;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.core.subsystems.Chassis;
import org.firstinspires.ftc.teamcode.core.subsystems.Subsystem;

import java.util.ArrayList;

/**
 * This class will store static instances of each of the modules.
 */
public class Robot{
    public static Chassis chassis;
    public static ArrayList<Subsystem> modules = new ArrayList<Subsystem>();
public Robot(HardwareMap hwMap)

{
 chassis = new Chassis(hwMap);
modules.add(chassis);
}

}
