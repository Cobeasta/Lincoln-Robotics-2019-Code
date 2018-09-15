package org.firstinspires.ftc.teamcode.util;

import java.util.ArrayList;

/**
 * This is the PID class to use for the robot.
 */
public class PID
{
    private long timeStamp, prevTimeStamp;
    private double kP, kI, kD, kF;
    private double error, previousError;
public PID(double kP, double kI, double kD, double kF)
{
    this.kP = kP;
    this.kI = kI;
    this.kD = kD;
    this.kF = kF;
}


    public double update()
    {
     double output = calculateP() -calculateD();
      error = previousError;
      return output;
    }
    public double calculateP()
    {
        return kP * error;
    }
    public double calculateD()
    {
        return kD *((error - previousError)/(double)(timeStamp - prevTimeStamp));
    }

    public double getP(){
    return kP;
    }
    public double getI()
    {
        return kI;
    }
    public double getD(){
        return kD;
    }
    public double getF(){
        return kF;
    }

    public void setP(double p){
    kP = p;
    }
    public void setI(double i){
    kI = i;
    }
    public void setD(double d){
    kD = d;
    }
    public void setF(double f){
    kF = f;
    }

}
