package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Robot {
    private static ElapsedTime elapsedTime;
    DcMotor leftFront, rightFront, backLeft, backRight;

    public Robot (HardwareMap hardwareMap) {
        elapsedTime = new ElapsedTime();
        elapsedTime.reset();

        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
    }
}
