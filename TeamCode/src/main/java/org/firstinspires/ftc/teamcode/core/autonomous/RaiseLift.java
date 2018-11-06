package org.firstinspires.ftc.teamcode.core.autonomous;

import org.firstinspires.ftc.teamcode.core.Command;
import org.firstinspires.ftc.teamcode.core.Robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.core.subsystems.Climber;

import static org.firstinspires.ftc.teamcode.core.Robot.climber;

public class RaiseLift extends Command {
    private int ticks;
    public RaiseLift(int ticks)
    {
        this.ticks = ticks;
    }

    @Override
    public void initialize() {
        climber.autoInit();
        climber.setTargetPosition(ticks);
    }

    @Override
    public void execute() {
        climber.runToPosition();


    }

    @Override
    public void stop() {
        climber.stop();

    }

    @Override
    public boolean isFinished() {
        return climber.reachedTargetPosition();
    }
}
