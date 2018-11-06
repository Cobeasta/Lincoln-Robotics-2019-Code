package org.firstinspires.ftc.teamcode.core.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.core.Auto;
import org.firstinspires.ftc.teamcode.core.commands.RaiseLift;
import org.firstinspires.ftc.teamcode.core.commands.TestChassis;
import org.firstinspires.ftc.teamcode.core.commands.TurnWithTime;
import org.firstinspires.ftc.teamcode.core.commands.Wait;
import org.firstinspires.ftc.teamcode.util.Constants;

@Autonomous(name = "Actual Autonomous: ", group = "Competitionn")
public class ActualAutonomous extends Auto {
    @Override
    public void addCommands() {
        addSequential(new RaiseLift(Constants.topClimber));
        addSequential(new Wait(1000));
        addSequential(new DriveToDistance(500));
        addSequential(new TurnWithTime(3000, -.5, .5));
    }
}
