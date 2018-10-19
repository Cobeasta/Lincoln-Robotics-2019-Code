package org.firstinspires.ftc.teamcode.core.autonomous;

import org.firstinspires.ftc.teamcode.core.Autonomous;
import org.firstinspires.ftc.teamcode.core.commands.TestChassis;

/**
 * This runs the test command on the following subsystems:
 *      Chassis
 */
@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "test the robot", group = "poop")
public class RunTest extends Autonomous {
    @Override
    public void addCommands() {
        addSequential(new TestChassis());
    }
}
