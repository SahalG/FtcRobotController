package org.firstinspires.ftc.teamcode.OpModes;

import com.pedropathing.follower.Follower;
import com.pedropathing.localization.Pose;
import com.pedropathing.pathgen.BezierCurve;
import com.pedropathing.pathgen.BezierLine;
import com.pedropathing.pathgen.PathChain;
import com.pedropathing.util.DashboardPoseTracker;
import com.pedropathing.util.Drawing;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.Robot.Robot;
import org.firstinspires.ftc.teamcode.MyTelemetry;


@Autonomous
public class FarBlueAuto extends LinearOpMode {
    Robot robot;
    private DashboardPoseTracker dashboardPoseTracker;
    private int pathState;
    public PathChain Path1;
    public PathChain Path2;
    public PathChain Path3;
    public PathChain Path4;
    public PathChain Path5;
    public PathChain Path6;
    public PathChain Path7;

    @Override
    public void runOpMode() throws InterruptedException {
        MyTelemetry.init(telemetry);
        robot = new Robot(hardwareMap);
        pathState = 0;
        Robot.follower.setStartingPose(new Pose(56, 8));
        Paths();
        waitForStart();
        while (opModeIsActive()) {
            Drawing.drawRobot(Robot.follower.getPose(), "#4CAF50");
            Drawing.sendPacket();
            robot.update();
            Drawing.drawPath(Path1, "F81616");
            Drawing.sendPacket();
            Drawing.drawPath(Path2, "F81616");
            Drawing.sendPacket();
            Drawing.drawPath(Path3, "F81616");
            Drawing.sendPacket();
            Drawing.drawPath(Path4, "F81616");
            Drawing.sendPacket();
            Drawing.drawPath(Path5, "F81616");
            Drawing.sendPacket();
            Drawing.drawPath(Path6, "F81616");
            Drawing.sendPacket();
            Drawing.drawPath(Path7, "F81616");
            Drawing.sendPacket();

            switch (pathState) {
                case 0:
                    Robot.follower.followPath(Path1, true);
                    pathState = 1;
                    break;
                case 1:
                    if (!Robot.follower.isBusy()) {
                        Robot.follower.followPath(Path2, true);
                        pathState = 2;

                    }
                    break;
                case 2:
                    if (!Robot.follower.isBusy()) {
                        Robot.follower.followPath(Path3, true);
                        pathState = 2;

                    }
                    break;
                case 3:
                    if (!Robot.follower.isBusy()) {
                        Robot.follower.followPath(Path4, true);
                        pathState = 2;

                    }
                    break;
                case 4:
                    if (!Robot.follower.isBusy()) {
                        Robot.follower.followPath(Path5, true);
                        pathState = 2;

                    }
                    break;
                case 5:
                    if (!Robot.follower.isBusy()) {
                        Robot.follower.followPath(Path6, true);
                        pathState = 2;

                    }
                    break;
                case 6:
                    if (!Robot.follower.isBusy()) {
                        Robot.follower.followPath(Path7, true);
                        pathState = 2;

                    }
                    break;
                case 7:
                    if (!Robot.follower.isBusy()) {
                        pathState = -1;

                    }
                    break;
            }
            robot.update();
        }
    }
    public void Paths() {
        Path1 = Robot.follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(56.000, 8.000), new Pose(56.000, 15.000))
                )
                .setLinearHeadingInterpolation(Math.toRadians(90), Math.toRadians(115))
                .build();

        Path2 = Robot.follower
                .pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(56.000, 15.000),
                                new Pose(46.000, 37.000),
                                new Pose(20.000, 36.000)
                        )
                )
                .setTangentHeadingInterpolation()
                .build();

        Path3 = Robot.follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(20.000, 36.000), new Pose(56.000, 15.000))
                )
                .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(115))
                .build();

        Path4 = Robot.follower
                .pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(56.000, 15.000),
                                new Pose(46.000, 61.000),
                                new Pose(20.000, 60.000)
                        )
                )
                .setTangentHeadingInterpolation()
                .build();

        Path5 = Robot.follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(20.000, 60.000), new Pose(56.000, 15.000))
                )
                .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(115))
                .build();

        Path6 = Robot.follower
                .pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(56.000, 15.000),
                                new Pose(46.000, 85.000),
                                new Pose(20.000, 84.000)
                        )
                )
                .setTangentHeadingInterpolation()
                .build();

        Path7 = Robot.follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(20.000, 84.000), new Pose(56.000, 15.000))
                )
                .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(115))
                .build();
    }
}
