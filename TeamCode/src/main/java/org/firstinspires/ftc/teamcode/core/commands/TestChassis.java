package org.firstinspires.ftc.teamcode.core.commands;

import org.firstinspires.ftc.teamcode.core.Command;
import org.firstinspires.ftc.teamcode.core.Robot;

import java.util.Date;

/**
 * Not to be run in competition. This tests the functionality of the Autonomous design.
 */
public class TestChassis extends Command {
  private long startTime;
  private long runtime;
  private boolean finished = false;
  public TestChassis()
  {
  }
  @Override
  public void initialize() {
    startTime = new Date().getTime();
    runtime = 0;
    finished = false;
  }

  @Override
    public void execute() {
    //How we find how long this command has been running.

    //Spin left
      if(runtime < 1000) Robot.chassis.tankDrive(.5, .5);
      else if(runtime < 2000) Robot.chassis.stop();

    }

    @Override
    public void stop() {
      Robot.chassis.stop();
    }

    @Override
    public boolean isFinished() {
        runtime = (new Date().getTime());
        runtime = runtime - startTime;
        return runtime > 4000;
    }
    public String toString(){
      String s = "";
      s += "test chassis Command:\n";
      s+= "Started: "+startTime;
      s+= "\n Current: " +runtime;
      s += runtime;
      return s;
    }
}
