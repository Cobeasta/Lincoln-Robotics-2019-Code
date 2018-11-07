package org.firstinspires.ftc.teamcode.core.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.core.Auto;
import org.firstinspires.ftc.teamcode.core.commands.RaiseLift;
import org.firstinspires.ftc.teamcode.core.commands.TestChassis;
import org.firstinspires.ftc.teamcode.core.commands.TurnWithTime;
import org.firstinspires.ftc.teamcode.core.commands.Wait;
import org.firstinspires.ftc.teamcode.util.Constants;

@Autonomous(name = "Actual Autonomous: ", group = "Competition")
public class ActualAutonomous extends Auto {
    @Override
    public void addCommands() {
        addSequential(new AdjustLiftFlipper(1));
        addSequential(new RaiseLift(Constants.bottomClimber));
        //addSequential(new Wait(1000));
        addSequential(new DriveToDistance(-250));
        addSequential(new TurnWithTime(10000, 1, -1));
        addSequential(new DriveToDistance(500));
        addSequential(new AdjustIntake(0));
        addSequential(new AdjustLiftFlipper(0));
        addSequential(new RaiseLift(Constants.topClimber));
    }
}
