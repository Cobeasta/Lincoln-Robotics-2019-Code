package org.firstinspires.ftc.teamcode.util;

public class Util {
public static double trim(double num, double min, double max)
{
    if(num < min) return min;
    if (num > max) return max;
    return num;
}

    /**
     * Returns 0 if the number is within a threshold of 0.
     * @param num
     * @param deadband
     * @return
     */
    public static double applyDeadband(double num, double deadband)
{
    return 0;
}
}