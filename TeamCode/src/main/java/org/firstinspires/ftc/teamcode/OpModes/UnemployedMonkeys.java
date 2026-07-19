package org.firstinspires.ftc.teamcode.OpModes;

import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
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
public class UnemployedMonkeys extends LinearOpMode {

    Robot robot;
    private DashboardPoseTracker dashboardPoseTracker;
    private int pathState;
    private ElapsedTime waitTimer = new ElapsedTime();

    public PathChain Path1;
    public PathChain Path2;
    public PathChain Path3;
    public PathChain Path4;

    @Override
    public void runOpMode() throws InterruptedException {
        MyTelemetry.init(telemetry);
        robot = new Robot(hardwareMap);
        pathState = 0;

        Robot.follower.setStartingPose(Poses.startPose);

        buildPaths();

        waitForStart();

        while (opModeIsActive()) {
            Drawing.drawRobot(Robot.follower.getPose(), "#4CAF50");
            Drawing.sendPacket();
            robot.update();

            switch (pathState) {
                case 0:
                    Robot.follower.followPath(Path1, true);
                    pathState = 1;
                    waitTimer.reset();
                    break;
                case 1:
                    if (!Robot.follower.isBusy() && waitTimer.milliseconds() >= 1000) {
                        Robot.follower.followPath(Path2, true);
                        pathState = 2;
                        waitTimer.reset();
                    }
                    break;
                case 2:
                    if (waitTimer.milliseconds() >= 1000 && !Robot.follower.isBusy()) {
                        Robot.follower.followPath(Path3, true);
                        pathState = 3;
                    }
                    break;
                case 3:
                    if (!Robot.follower.isBusy()) {
                        Robot.follower.followPath(Path4, true);
                        pathState = 4;
                    }
                    break;
                case 4:
                    if (!Robot.follower.isBusy()) {
                        pathState = -1;
                    }
                    break;
            }

            robot.update();
        }
    }

    public void buildPaths() {
        Path1 = Robot.follower
                .pathBuilder()
                .addPath(
                        new BezierCurve(Poses.p1Start, Poses.p1Control, Poses.p1End)
                )
                .setTangentHeadingInterpolation()
                .build();

        Path2 = Robot.follower
                .pathBuilder()
                .addPath(
                        new BezierCurve(Poses.p2Start, Poses.p2Control, Poses.p2End)
                )
                .setLinearHeadingInterpolation(Poses.heading180, Poses.heading120)
                .build();

        Path3 = Robot.follower
                .pathBuilder()
                .addPath(
                        new BezierCurve(Poses.p3Start, Poses.p3Control, Poses.p3End)
                )
                .setTangentHeadingInterpolation()
                .build();

        Path4 = Robot.follower
                .pathBuilder()
                .addPath(
                        new BezierCurve(Poses.p4Start, Poses.p4Control, Poses.p4End)
                )
                .setLinearHeadingInterpolation(Poses.heading180, Poses.heading120)
                .build();
    }
}