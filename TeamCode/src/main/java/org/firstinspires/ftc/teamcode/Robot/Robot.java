package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.MyTelemetry;

import java.util.List;

public class Robot {
    private static ElapsedTime elapsedTime;
    public List<LynxModule> hubs;
    DcMotor leftFront, rightFront, backLeft, backRight;


    public double loopTime;
    public float Hz;

    public Robot (HardwareMap hardwareMap) {
        elapsedTime = new ElapsedTime();
        elapsedTime.reset();

//        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
//        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
//        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
//        backRight = hardwareMap.get(DcMotor.class, "backRight");


        hubs = hardwareMap.getAll(LynxModule.class);
        for (LynxModule hub : hubs) {
            hub.setBulkCachingMode(LynxModule.BulkCachingMode.MANUAL);
        }
    }

    public void update () {


        for(LynxModule hub : hubs){
            hub.clearBulkCache();
        }

        loopTime = elapsedTime.milliseconds();
        Hz = (float) (1000/loopTime);
        MyTelemetry.addData("Loop Time", loopTime);
        MyTelemetry.addData("Hz", Hz);
        MyTelemetry.update();
        elapsedTime.reset();
    }}
