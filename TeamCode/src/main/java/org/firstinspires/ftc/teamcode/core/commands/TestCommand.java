package org.firstinspires.ftc.teamcode.core.commands;

import org.firstinspires.ftc.teamcode.core.Command;
import org.firstinspires.ftc.teamcode.core.Robot;

import java.util.Date;

/**
 * Not to be run in competition. This tests the functionality of the Autonomous design.
 */
public class TestCommand extends Command {
  private long startTime;
  private long runtime;
  private boolean finished;
  public TestCommand()
  {

  }
  @Override
  public void initialize() {
    startTime = new Date().getTime();
    runtime = 0;
  }

  @Override
    public void execute() {
    //How we find how long this command has been running.
    runtime = new Date().getTime() - startTime;
    //Spin right
      if(runtime < 3000) Robot.chassis.tankDrive(.5, -.5);
      else if(runtime < 3500) Robot.chassis.stop();
      //spin left
      else if(runtime < 6000) Robot.chassis.tankDrive(-0.5, 0.5);
      else if(runtime < 6500) Robot.chassis.stop();
      //Drive forwards.
      else if(runtime < 9000) Robot.chassis.tankDrive(0.25, 0.25);
      else finished = true;
    }

    @Override
    public void stop() {
      Robot.chassis.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
