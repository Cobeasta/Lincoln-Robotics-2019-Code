package org.firstinspires.ftc.teamcode.core.subsystems;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.util.Constants;

public class IntakeFlipper extends Subsystem {
    private double pos = 0;
    private Servo flipper;
    public IntakeFlipper(HardwareMap map) {
        super(map);
        flipper = hardwaremap.servo.get(Constants.intakeFlipper);
    }

    @Override
    public void teleopControls(Gamepad gamepad1, Gamepad gamepad2) {
        if(gamepad2.a) flipper.setPosition(0);
        else if(gamepad2.y) flipper.setPosition(1);


    }

    @Override
    public String addTelemetry() {
        return "";
    }

    @Override
    public void stop() {

    }
}
