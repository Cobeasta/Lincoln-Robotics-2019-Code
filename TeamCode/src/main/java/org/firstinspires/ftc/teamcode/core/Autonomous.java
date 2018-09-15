package org.firstinspires.ftc.teamcode.core;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import java.util.ArrayList;

public abstract class Autonomous extends OpMode{
private ArrayList<Command> commands = new ArrayList<Command>();
private ArrayList<Command> activeCommands = new ArrayList<Command>();

    private State state;
    /**
     * Runs once before the robot starts.
     * Here we initialize the hardware for the robot.
     */
    @Override
    public void init() {

        state = State.INIT;
        activeCommands.add(commands.get(0));
    }

    /**
     * Repeats during the match's active time.
     */
    public void loop(){
        switch(state)
        {
            case INIT:
                for(Command c: activeCommands)
                {
                    if(!c.getInitialized())
                    {
                        c.init();
                    }
                }
                state = State.EXECUTE;
                break;
            case EXECUTE:
                for(Command c:activeCommands){
                    if(c.isFinished()) activeCommands.remove(c);
                }
                for(Command c:activeCommands){
                    c.execute();

                }
                if(activeCommands.size() == 0) state = State.STOP;
                break;

            case STOP:
                if(commands.size() > 0){
                    activeCommands.set(0,commands.get(0));
                    }
                break;
            case DONE:
                break;
        }
    }
private enum State{
       INIT, EXECUTE, STOP, DONE;
}



}
