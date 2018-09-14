package org.firstinspires.ftc.teamcode.core.core.subsystems;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public abstract class Subsystem {
    HardwareMap hardwaremap;
    public Subsystem(HardwareMap map)
    {
        this.hardwaremap = map;
    }
    public abstract void teleopControls(Gamepad gamepad);
}
