package org.firstinspires.ftc.teamcode.core.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.util.Constants;

public class BotterLifterer extends Subsystem{

    private DcMotor botLift;

    public BotterLifterer(HardwareMap map) {
        super(map);

        botLift = map.dcMotor.get(Constants.botterLifterer);
    }

    @Override
    public void teleopControls(Gamepad gamepad1, Gamepad gamepad2) {
        if (gamepad1.right_trigger > 0) {
            botLift.setPower(gamepad1.right_trigger);
        }
        else if (gamepad1.left_trigger > 0){
            botLift.setPower(gamepad1.left_trigger);
        }
    }

    @Override
    public void stop() {

    }
    @Override
    public String addTelemetry(){
        return "";
    }
}
