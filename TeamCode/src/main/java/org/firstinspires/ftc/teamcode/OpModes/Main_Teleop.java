package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.MyTelemetry;
import org.firstinspires.ftc.teamcode.Robot.Robot;


@TeleOp (name = "Main Teleop")
public class Main_Teleop extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        MyTelemetry.init(telemetry);
        Robot robot = new Robot(hardwareMap);

        Gamepad gp1 = new Gamepad();
        Gamepad gp2 = new Gamepad();

        waitForStart();

        while (opModeIsActive()) {
            if (gp1.y) {
                MyTelemetry.addData("Y Button", true);
            }
            if (gp1.right_trigger > 0) {
                MyTelemetry.addData("Right Trigger", gp1.right_trigger);
            }
            if (gp1.dpad_down) {
                MyTelemetry.addData("Dpad Down", true);
            }
            robot.update();

        }
    }
}
