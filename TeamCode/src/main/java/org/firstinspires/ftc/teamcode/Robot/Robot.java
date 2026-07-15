package org.firstinspires.ftc.teamcode.Robot;

import com.pedropathing.follower.Follower;
import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.pedroPathing.constants.LConstants;
import org.firstinspires.ftc.teamcode.pedroPathing.constants.FConstants;

import org.firstinspires.ftc.teamcode.MyTelemetry;

import java.util.List;

public class Robot {
    private static ElapsedTime elapsedTime;
    public List<LynxModule> hubs;
    DcMotor leftFront, rightFront, backLeft, backRight;


    public double loopTime;
    public static Follower follower;
    public float Hz;

    public Robot (HardwareMap hardwareMap) {
        follower = new Follower(hardwareMap, FConstants.class, LConstants.class);
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
        follower.update();
    }}
