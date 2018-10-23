package org.firstinspires.ftc.teamcode.core.subsystems;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.util.Constants;

public class IntakeFlipper extends Subsystem {
    private double pos = 0;
    private Servo flipper;
    private boolean altControl;
    public IntakeFlipper(HardwareMap map) {
        super(map);
        flipper = hardwaremap.servo.get(Constants.intakeFlipper);
        pos = 0;
        flipper.setPosition(pos);
        altControl = false;
    }

    @Override
    public void teleopControls(Gamepad gamepad1, Gamepad gamepad2) {
        if (gamepad2.right_bumper) altControl = !altControl;
        if (altControl){
            if(gamepad2.a) pos += 0.05;
            else if(gamepad2.y) pos -= 0.05;
            flipper.setPosition(pos);
        }
        else {
            if(gamepad2.a) flipper.setPosition(0);
            else if(gamepad2.b) flipper.setPosition(0.5);
            else if(gamepad2.y) flipper.setPosition(1);
        }


    }

    @Override
    public String addTelemetry() {
        return "";
    }

    @Override
    public void stop() {

    }
}
