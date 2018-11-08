package org.firstinspires.ftc.teamcode.core.autonomous;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.fakeCode.HardwarePushbot;

@Autonomous(name="New Auto Testing", group="tester bot")
public class Autonomous_Revisioned extends OpMode {


    ElapsedTime runtime = new ElapsedTime();
    //HardwarePushbot robot   = new HardwarePushbot();
    DcMotor leftDrive;// = hardwareMap.dcMotor.get("leftdrive");
    DcMotor rightDrive;// = hardwareMap.dcMotor.get("rightdrive");
    boolean flag = true;


    public void init(){
        //robot.init(hardwareMap);
        //rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        System.out.println("Ran Init");

        leftDrive = hardwareMap.dcMotor.get("leftdrive");
        rightDrive = hardwareMap.dcMotor.get("rightdrive");

    }

    @Override
    public void loop() {
        System.out.println("Ran loop");
        runtime.reset();
        if(flag) {
//            while (runtime.seconds() < 3.0) {
//                leftDrive.setPower(1);
//                rightDrive.setPower(1);
//                System.out.println("Runtime: " + runtime.seconds());
//            }
//            flag =false;
//            leftDrive.setPower(0);
//            rightDrive.setPower(0);


        }

    }

    @Override
    public void stop(){
        leftDrive.setPower(0);
        rightDrive.setPower(0);
    }

}
