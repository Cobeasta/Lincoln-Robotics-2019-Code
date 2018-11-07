package org.firstinspires.ftc.teamcode.core.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.core.Auto;
import org.firstinspires.ftc.teamcode.core.commands.RaiseLift;
import org.firstinspires.ftc.teamcode.core.commands.TurnWithTime;
import org.firstinspires.ftc.teamcode.core.commands.Wait;
import org.firstinspires.ftc.teamcode.util.Constants;

/**
 * This runs the test command on the following subsystems:
 *      Chassis
 */
@Autonomous(name = "test Climber", group = "test")
public class RunTest extends Auto{

    @Override
    public void addCommands() {
        //addSequential(new RaiseLift(Constants.landingNumber));
        //addSequential(new TurnToAngle(90));
        addSequential(new TurnWithTime(1000, 1, -1));
        addSequential(new Wait(1000));

    }
}

