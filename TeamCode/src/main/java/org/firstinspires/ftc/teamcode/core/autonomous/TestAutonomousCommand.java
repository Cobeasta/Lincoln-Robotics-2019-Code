package org.firstinspires.ftc.teamcode.core.autonomous;

import org.firstinspires.ftc.teamcode.core.Auto;

public class TestAutonomousCommand extends Auto {
    @Override
    public void addCommands() {
        addSequential(new RaiseLift(3000));
    }
}
