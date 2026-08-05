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



        gp1.getGamepadButton(GamepadKeys.Button.A).whenPressed(
                new InstantCommand(robot::holdPose)
        );

        gp1.getGamepadButton(GamepadKeys.Button.A).whenReleased(
                new InstantCommand(robot::breakFollowing)
        );

        gp2.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenPressed(
                new ShooterCommand(robot, Shooter.ShooterState.CLOSE)
        );
        gp2.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenPressed(
                new ShooterCommand(robot, Shooter.ShooterState.FAR)
        );
        gp2.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenPressed(
                new ShooterCommand(robot, Shooter.ShooterState.MATH)
        );
        gp2.getGamepadButton(GamepadKeys.Button.DPAD_DOWN).whenPressed(
                new ShooterCommand(robot, Shooter.ShooterState.LINEAR)
        );
        gp2.getGamepadButton(GamepadKeys.Button.X).whenPressed(
                new ShooterCommand(robot, Shooter.ShooterState.STOP)
        );


        waitForStart();

        while (opModeIsActive()) {


            Robot.follower.setTeleOpMovementVectors(-gamepad1.left_stick_y, -gamepad1.left_stick_x, -gamepad1.right_stick_x);
            robot.update();
            MyTelemetry.update();
            }



        }
    }
