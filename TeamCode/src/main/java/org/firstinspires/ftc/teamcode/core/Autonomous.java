package org.firstinspires.ftc.teamcode.core;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public abstract class Autonomous extends OpMode{

    /**
     * Runs once before the robot starts.
     * Here we initialize the hardware for the robot.
     */
    @Override
    public void init() {

    }

    /**
     * Repeats during the match's active time.
     */
    public void loop(){

    }

    /**
     * This method will lower the robot from the platform
     * and return true once it is done.
     */
    protected boolean land(){
    return true;
}



}
