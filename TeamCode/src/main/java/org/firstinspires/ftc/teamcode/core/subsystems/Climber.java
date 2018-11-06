package org.firstinspires.ftc.teamcode.core.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.util.Constants;

public class Climber extends Subsystem {



    private DcMotor motor;
    public Climber(HardwareMap map) {
        super(map);
        motor = map.dcMotor.get(Constants.climber);
    }

    @Override
    public void teleopControls(Gamepad gamepad1, Gamepad gamepad2) {
        if(gamepad1.right_trigger > 0.2){
            motor.setPower(gamepad1.right_trigger);
        }
        else if(gamepad1.left_trigger > 0.2){
            motor.setPower(-gamepad1.left_trigger);
        }
        else{
            motor.setPower(0);
        }
    }

    @Override
    public String addTelemetry() {

        String s = "Climber motor power: " + motor.getPower();

        return s;
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
