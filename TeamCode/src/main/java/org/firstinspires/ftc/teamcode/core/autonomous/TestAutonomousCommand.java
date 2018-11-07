package org.firstinspires.ftc.teamcode.core.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.core.Auto;

@Autonomous(name = "Test encoder drive", group = "test")
public class TestAutonomousCommand extends Auto {
    @Override
    public void addCommands() {
        //addSequential(new DriveToDistance(4000));
        addParallel(new RaiseLift(2000));
        addParallel(new DriveToDistance(500));

    }
}
