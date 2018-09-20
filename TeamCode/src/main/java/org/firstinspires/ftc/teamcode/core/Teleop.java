package org.firstinspires.ftc.teamcode.core;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.core.subsystems.Subsystem;


public class Teleop extends OpMode{
    /**
     * Initialize any subsystems that need initializing before the game starts.
     */
    @Override
    public void init() {

    }

    /**
     * Calls the teleop control method in all subsystems.
     */
    @Override
    public void loop() {
        for(Subsystem system: Robot.modules)
        {
            system.teleopControls(gamepad1, gamepad2);
        }
    }
}
