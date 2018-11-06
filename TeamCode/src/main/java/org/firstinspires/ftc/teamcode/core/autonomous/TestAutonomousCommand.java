package org.firstinspires.ftc.teamcode.core.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.core.Auto;
import org.firstinspires.ftc.teamcode.util.Constants;

@Autonomous(name="Test Climb", group="testing")

public class TestAutonomousCommand extends Auto {
    @Override
    public void addCommands() {
        addSequential(new RaiseLift(Constants.topClimber));
    }
}
