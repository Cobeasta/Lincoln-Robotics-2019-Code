package org.firstinspires.ftc.teamcode.core.commands;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.core.Robot;

@Autonomous(name = "Basic Straigh Auto", group = "basic")
public class BasicStraightAuto extends LinearOpMode{

    @Override
    public void runOpMode() throws InterruptedException {
        if(!Robot.initialized) new Robot(hardwareMap);
        Robot.chassis.startAccelerationIntegration();
        waitForStart();
        while(this.getRuntime() * 1000 < 5000)
        {
            Robot.chassis.arcadeDrive(.5,0);
        }
        Robot.chassis.stop();
    }
}
