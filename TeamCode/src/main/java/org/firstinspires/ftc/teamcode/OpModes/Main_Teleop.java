package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.MyTelemetry;
import org.firstinspires.ftc.teamcode.Robot.Robot;


@TeleOp (name = "Main Teleop")
public class Main_Teleop extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        MyTelemetry.init(telemetry);
        Robot robot = new Robot(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            robot.update();

        }
    }
}
