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

        // Currently takes ~10 to lower the bot.  Needs to be taken into account

        addSequential(new RaiseLift(Constants.bottomClimber));
        //addSequential(new Wait(1000));

        // TODO Drive time needs to be calculated and measured
        // Found negative drive distances do properly back the bot
        // TODO -250 is slightly too long
        addSequential(new DriveToDistance(-250));

        addSequential(new TurnWithTime(1000, 1, -1));
        addSequential(new DriveToDistance(500));
        addSequential(new AdjustIntake(0));

        // Just enough time to move the intake out of the way
        addSequential(new Wait(500));
        addSequential(new AdjustLiftFlipper(0));

        // TODO This ideally needs to be running right after the first turn.
        // It still takes ~10 to lower the lift, even with no weight
        addSequential(new RaiseLift(Constants.topClimber));
    }
}
