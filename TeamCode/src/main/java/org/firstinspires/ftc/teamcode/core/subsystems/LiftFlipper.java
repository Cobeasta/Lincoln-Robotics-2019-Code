package org.firstinspires.ftc.teamcode.core.subsystems;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.util.Constants;

public class LiftFlipper extends Subsystem {
    private double pos = 0;
    private Servo flipper;
    public LiftFlipper(HardwareMap map) {
        super(map);
        flipper = hardwaremap.servo.get(Constants.liftFlipper);

    }

    @Override
    public void teleopControls(Gamepad gamepad1, Gamepad gamepad2) {
        if(gamepad2.dpad_down) flipper.setPosition(0);
        else if(gamepad2.dpad_up) flipper.setPosition(1);
    }

    @Override
    public String addTelemetry() {
        return "";
    }

    @Override
    public void stop() {

    }
}
