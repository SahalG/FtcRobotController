package org.firstinspires.ftc.teamcode.OpModes;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Robot.Commands.ShooterCommand;

import org.firstinspires.ftc.teamcode.MyTelemetry;
import org.firstinspires.ftc.teamcode.Robot.Robot;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.Shooter;


@TeleOp (name = "Main Teleop")
public class Main_Teleop extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        MyTelemetry.init(telemetry);
        Robot robot = new Robot(hardwareMap);

        GamepadEx gp1 = new GamepadEx(gamepad1);
        GamepadEx gp2 = new GamepadEx(gamepad2);

        gp2.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenPressed(
                new ShooterCommand(robot, Shooter.ShooterState.CLOSE)
        );
        gp2.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenPressed(
                new ShooterCommand(robot, Shooter.ShooterState.FAR)
        );
        gp2.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenReleased(
                new ShooterCommand(robot, Shooter.ShooterState.STOP)
        );
        gp2.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenReleased(
                new ShooterCommand(robot, Shooter.ShooterState.STOP)
        );

        waitForStart();

        while (opModeIsActive()) {

            telemetry.addLine("Gamepad Controls");
            telemetry.addLine();
//CONTROLS
//            if (gp1.a) telemetry.addLine("A is being pressed");
//            if (gp1.b) telemetry.addLine("B is being pressed");
//            if (gp1.x) telemetry.addLine("X is being pressed");
//            if (gp1.y) telemetry.addLine("Y is being pressed");
//
//            if (gp1.dpad_up) telemetry.addLine("Dpad Up is being pressed");
//            if (gp1.dpad_down) telemetry.addLine("Dpad Down is being pressed");
//            if (gp1.dpad_left) telemetry.addLine("Dpad Left is being pressed");
//            if (gp1.dpad_right) telemetry.addLine("Dpad Right is being pressed");
//
//            if (gp1.left_bumper) telemetry.addLine("Left Bumper is being pressed");
//            if (gp1.right_bumper) telemetry.addLine("Right Bumper is being pressed");
//            if (gp1.left_trigger > 0) telemetry.addLine("Left Trigger: " + gp1.left_trigger);
//            if (gp1.right_trigger > 0) telemetry.addLine("Right Trigger: " + gp1.right_trigger);
//
//            if (gp1.left_stick_y != 0 ) telemetry.addLine("Left Stick Y: " + gp1.left_stick_y);
//            if (gp1.left_stick_x != 0 ) telemetry.addLine("Left Stick X: " + gp1.left_stick_x);
//            if (gp1.right_stick_y != 0 ) telemetry.addLine("Right Stick Y: " + gp1.right_stick_y);
//            if (gp1.right_stick_x != 0 ) telemetry.addLine("Right Stick X: " + gp1.right_stick_x);


            Robot.follower.setTeleOpMovementVectors(-gamepad1.left_stick_y, -gamepad1.left_stick_x, -gamepad1.right_stick_x);
            }

            robot.update();

        }
    }
