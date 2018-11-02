package org.firstinspires.ftc.teamcode.core.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Climber extends Subsystem {



    private DcMotor motor;
    public Climber(HardwareMap map) {
        super(map);
        motor = map.dcMotor.get("lift_motor");
    }

    @Override
    public void teleopControls(Gamepad gamepad1, Gamepad gamepad2) {

    }

    @Override
    public String addTelemetry() {
        return "";
    }

    @Override
    public void stop() {
        motor.setPower(0);
    }

    public void setPower(double power)
    {
        motor.setPower(power);
    }

    /**
     * Sets the runmode to position.
     *
     */
    @Override
    public void autoInit()
    {
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    @Override
    public void teleopInit()
    {
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }


    /**
     * Sets the position for the climber to move to.
     * You can use Constants.liftPosition** to move to top, middle, or bottom.
     * Another option is to set the power in ticks.
     *
     * @warning This method is useless unless you call runToPosition repeatedly afterwards
     * @param position
     */
    public void setTargetPosition(int position)
    {
        motor.setTargetPosition(position + motor.getCurrentPosition());
    }
    public void runToPosition()
    {
        motor.setPower(1);
    }
    public boolean reachedTargetPosition()
    {
        return Math.abs(motor.getTargetPosition() - motor.getCurrentPosition()) > 50;
    }

}
