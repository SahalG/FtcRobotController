package org.firstinspires.ftc.teamcode.OpModes;

import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.pedropathing.follower.Follower;
import com.pedropathing.localization.Pose;
import com.pedropathing.pathgen.BezierCurve;
import com.pedropathing.pathgen.BezierLine;
import com.pedropathing.pathgen.PathChain;
import com.pedropathing.util.DashboardPoseTracker;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Robot.ComboCommands.FollowPathCommand;
import org.firstinspires.ftc.teamcode.Robot.ComboCommands.ReleaseThreeCommand;
import org.firstinspires.ftc.teamcode.Robot.Commands.BlockerCommand;
import org.firstinspires.ftc.teamcode.Robot.Commands.IntakeCommand;
import org.firstinspires.ftc.teamcode.Robot.Commands.ShooterCommand;
import org.firstinspires.ftc.teamcode.Robot.Robot;
import org.firstinspires.ftc.teamcode.MyTelemetry;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.Blocker;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.Intake;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.Shooter;

@Autonomous
public class LibCloseBlueAuto extends LinearOpMode {

    Robot robot;
    public PathChain Chain1, Chain2, Chain3, Chain4;
    public Follower follower = Robot.follower;

    @Override
    public void runOpMode() throws InterruptedException {
        MyTelemetry.init(telemetry);
        robot = new Robot(hardwareMap);

        Robot.follower.setStartingPose(AutoConstants.startPose);
        Paths(follower);
        CommandScheduler.getInstance().schedule(new BlockerCommand(robot, Blocker.BlockerState.CLOSED));
        CommandScheduler.getInstance().schedule(new IntakeCommand(robot, Intake.IntakeState.OFF));

        SequentialCommandGroup auto = new SequentialCommandGroup(
                new FollowPathCommand(follower, Chain1),
                new ReleaseThreeCommand(robot),
                new IntakeCommand(robot, Intake.IntakeState.ON),

                new FollowPathCommand(follower, Chain2),
                new ReleaseThreeCommand(robot),
                new IntakeCommand(robot, Intake.IntakeState.ON),

                new FollowPathCommand(follower, Chain3),
                new ReleaseThreeCommand(robot),
                new IntakeCommand(robot, Intake.IntakeState.ON),

                new FollowPathCommand(follower, Chain4),
                new ReleaseThreeCommand(robot)

        );


        waitForStart();



        CommandScheduler.getInstance().schedule(new ShooterCommand(robot, Shooter.ShooterState.CLOSE));
        CommandScheduler.getInstance().schedule(auto);

        while (opModeIsActive()) {
            robot.update();
        }

        }

    public void Paths (Follower follower){
        // ----- Chain 1 -----
        Chain1 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                AutoConstants.startPointOne,
                                AutoConstants.endPointOne
                        )
                )
                .setLinearHeadingInterpolation(AutoConstants.startHeadingOne, AutoConstants.endHeadingOne)
                .build();

        // ----- Chain 2 -----
        Chain2 = follower.pathBuilder()
                .addPath(
                        new BezierCurve(
                                AutoConstants.startPointTwo,
                                AutoConstants.controlPointTwo,
                                AutoConstants.endPointTwo
                        )
                )
                .setLinearHeadingInterpolation(AutoConstants.startHeadingTwo, AutoConstants.endHeadingTwo)
                .addPath(
                        new BezierCurve(
                                AutoConstants.endPointTwo,
                                AutoConstants.controlPointTwo,
                                AutoConstants.startPointTwo
                        )
                )
                .setLinearHeadingInterpolation(AutoConstants.endHeadingTwo, AutoConstants.startHeadingTwo)
                .build();

        // ----- Chain 3 -----
        Chain3 = follower.pathBuilder()
                .addPath(
                        new BezierCurve(
                                AutoConstants.startPointThree,
                                AutoConstants.controlPointThree,
                                AutoConstants.endPointThree
                        )
                )
                .setLinearHeadingInterpolation(AutoConstants.startHeadingThree, AutoConstants.endHeadingThree)
                .addPath(
                        new BezierCurve(
                                AutoConstants.endPointThree,
                                AutoConstants.controlPointThree,
                                AutoConstants.startPointThree
                        )
                )
                .setLinearHeadingInterpolation(AutoConstants.endHeadingThree, AutoConstants.startHeadingThree)
                .build();

        // ----- Chain 4 -----
        Chain4 = follower.pathBuilder()
                .addPath(
                        new BezierCurve(
                                AutoConstants.startPointFour,
                                AutoConstants.controlPointFour,
                                AutoConstants.endPointFour
                        )
                )
                .setLinearHeadingInterpolation(AutoConstants.startHeadingFour, AutoConstants.endHeadingFour)
                .addPath(
                        new BezierCurve(
                                AutoConstants.endPointFour,
                                AutoConstants.controlPointFour,
                                AutoConstants.startPointFour
                        )
                )
                .setLinearHeadingInterpolation(AutoConstants.endHeadingFour, AutoConstants.startHeadingFour)
                .build();
    }
}
