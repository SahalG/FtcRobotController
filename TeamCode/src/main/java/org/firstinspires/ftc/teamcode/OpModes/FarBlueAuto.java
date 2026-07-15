package org.firstinspires.ftc.teamcode.OpModes;

import com.pedropathing.follower.Follower;
import com.pedropathing.localization.Pose;
import com.pedropathing.pathgen.BezierCurve;
import com.pedropathing.pathgen.BezierLine;
import com.pedropathing.pathgen.PathChain;
import com.pedropathing.util.DashboardPoseTracker;
import com.pedropathing.util.Drawing;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.Robot.Robot;
import org.firstinspires.ftc.teamcode.MyTelemetry;



public class FarBlueAuto extends LinearOpMode {
    Robot robot;
    Follower follower = Robot.follower;
    private DashboardPoseTracker dashboardPoseTracker;
    private ElapsedTime timer;
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
        robot = new Robot(hardwareMap);
        Paths(follower);
        pathState = 0;
        dashboardPoseTracker = new DashboardPoseTracker(follower.poseUpdater);
        follower.setStartingPose(new Pose(56, 8));
        Drawing.drawRobot(follower.poseUpdater.getPose(), "#4CAF50");
        Drawing.sendPacket();
        timer.reset();

        while (opModeIsActive()) {
            MyTelemetry.addData("POSE", follower.getPose());
            robot.update();
            dashboardPoseTracker.update();
            Drawing.drawPoseHistory(dashboardPoseTracker, "#4CAF50");
            Drawing.drawRobot(follower.poseUpdater.getPose(), "#4CAF50");
            Drawing.sendPacket();

            switch (pathState) {
                case 0:
                    follower.followPath(Path1, true);
                    pathState = 1;
                    break;
                case 1:
                    if (!follower.isBusy()) {
                        follower.followPath(Path2, true);
                        pathState = 2;

                    }
                    break;
                case 2:
                    if (!follower.isBusy()) {
                        follower.followPath(Path3, true);
                        pathState = 2;

                    }
                    break;
                case 3:
                    if (!follower.isBusy()) {
                        follower.followPath(Path4, true);
                        pathState = 2;

                    }
                    break;
                case 4:
                    if (!follower.isBusy()) {
                        follower.followPath(Path5, true);
                        pathState = 2;

                    }
                    break;
                case 5:
                    if (!follower.isBusy()) {
                        follower.followPath(Path6, true);
                        pathState = 2;

                    }
                    break;
                case 6:
                    if (!follower.isBusy()) {
                        follower.followPath(Path7, true);
                        pathState = 2;

                    }
                    break;
                case 7:
                    if (!follower.isBusy()) {
                        pathState = -1;

                    }
                    break;
            }
            robot.update();
        }
    }
    public void Paths(Follower follower) {
        Path1 = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(56.000, 8.000), new Pose(56.000, 15.000))
                )
                .setLinearHeadingInterpolation(Math.toRadians(90), Math.toRadians(115))
                .build();

        Path2 = follower
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

        Path3 = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(20.000, 36.000), new Pose(56.000, 15.000))
                )
                .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(115))
                .build();

        Path4 = follower
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

        Path5 = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(20.000, 60.000), new Pose(56.000, 15.000))
                )
                .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(115))
                .build();

        Path6 = follower
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

        Path7 = follower
                .pathBuilder()
                .addPath(
                        new BezierLine(new Pose(20.000, 84.000), new Pose(56.000, 15.000))
                )
                .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(115))
                .build();
    }
}
