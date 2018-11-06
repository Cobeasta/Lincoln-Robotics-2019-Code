package org.firstinspires.ftc.teamcode.core;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.core.subsystems.Subsystem;

import java.util.ArrayList;
import java.util.Date;

public abstract class Auto extends OpMode{
private ArrayList<Command> commands = new ArrayList<Command>();
private ArrayList<Command> activeCommands = new ArrayList<Command>();
    private State state = State.INIT;

    /**
     * Requires the autonomous to add the commands that will run for the duration of autonomous
     */
    public abstract void addCommands();
    /**
     * Runs once before the robot starts.
     * Here we initialize the hardware for the robot.
     */
    @Override
    public void init() {
        if(!Robot.initialized)new Robot(hardwareMap);
        addCommands();
//        Robot.chassis.startGyro();
        state = State.INIT;
        activeCommands.add(commands.get(0));
        commands.remove(0);
//Now parse through the next commands and check if they are meant to run at the current command.
        for(Command c: commands){
            if(c.parallel){
                activeCommands.add(c);
                commands.remove(c);
            }
//                        Stop at the next sequential command
            else{
                break;
            }
        }
        Robot.chassis.autoInit();
        Robot.climber.autoInit();
        System.out.println("Active Commands:" +activeCommands);
        System.out.println("Queue: " + commands);
    }

    /**
     * Repeats during the match's active time.
     */
    public void loop(){
        for(Subsystem s: Robot.modules)
        {
            telemetry.addData("Subsystem: \n\n", s.addTelemetry());
        }
        switch(state)
        {
            case INIT:
//                Initialize the active commands and move to execute.
                for(Command c: activeCommands)
                {
                    if(!c.initialized)
                    {

                        c.init();
                        System.out.println("Initializing Command: " + c);
                    }
                }
                state = State.EXECUTE;
                break;
            case EXECUTE:
//                Execute all of the current commands and remove the finished ones.

                for(Command c:activeCommands){
                    c.execute();


                }
                for(Command c:activeCommands){

                    if(c.isFinished()){
                        System.out.println("Removing Command: " + c);
                        c.stop();
                        activeCommands.remove(c);
                    }
                }
//                Move to stop once all of the current commands have run.
                if(activeCommands.size() == 0) state = State.STOP;
                break;


            case STOP:
                System.out.println("State Stop!");
//                If there is another command, add it.
                if(commands.size() > 0)
                {
                    activeCommands.add(commands.get(0));
                    commands.remove(0);
//                    Now parse through the next commands and check if they are meant to run at the
//                    current command.
                    for(Command c: commands){
                        if(c.parallel)
                        {
                            activeCommands.add(c);
                            commands.remove(c);
                        }
//                        Stop at the next sequential command
                        else
                        {
                            break;
                        }
                    }
                    state = State.INIT;
                    System.out.println("Active Commands: " + activeCommands);
                    System.out.println("Queued Commands: " + commands);
                }
//                    If there are no more commands, then autonomous is over.
                else
                {
                    state = State.DONE;
                }
                break;
            case DONE:
                break;

        }
        telemetry.addData("Chassis: ", Robot.chassis);
        telemetry.addData("State: ", state);
        telemetry.addData("current command", activeCommands);

    }

    /**
     * An enum for the state of autonomous. This makes variable manipulation easier.
     */
    private enum State{
       INIT, EXECUTE, STOP, DONE;
}

    /**
     * Call this method to add a command to run after the previous commands in autonomous.
     * @param command
     */
    protected void addSequential(Command command) {
        commands.add(command);

}

    /**
     * Adds a command to run at the same time as the previous one. This cascades so it will run with
     * other parallel commands and 1 sequential command.
     * @param command
     */
    protected void addParallel(Command command)
    {
        command.parallel = true;
        commands.add(command);

    }
}
