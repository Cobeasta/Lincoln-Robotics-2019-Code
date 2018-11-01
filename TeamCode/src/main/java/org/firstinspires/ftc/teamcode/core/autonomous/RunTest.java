package org.firstinspires.ftc.teamcode.core.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.core.Auto;
import org.firstinspires.ftc.teamcode.core.commands.Blank;
import org.firstinspires.ftc.teamcode.core.commands.TestChassis;

/**
 * This runs the test command on the following subsystems:
 *      Chassis
 */
@Autonomous(name = "test everything!", group = "poop")
public class RunTest extends Auto{

    @Override
    public void addCommands() {
        addSequential(new DriveToDistance(5000));
    }
}

