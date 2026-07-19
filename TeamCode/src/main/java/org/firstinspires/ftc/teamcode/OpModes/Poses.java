package org.firstinspires.ftc.teamcode.OpModes;

import com.pedropathing.localization.Pose;

public class Poses {

    // Starting pose
    public static final Pose startPose = new Pose(25, 125, Math.toRadians(140));

    // Path 1 control points
    public static final Pose p1Start   = new Pose(56.000, 12.500);

    public static final double heading180 = Math.toRadians(180);
    public static final double heading120 = Math.toRadians(120);

    public static final Pose p1Control = new Pose(54.500, 37.000);
    public static final Pose p1End     = new Pose(13.500, 35.500);

    // Path 2 control points (reverse of Path 1)
    public static final Pose p2Start   = new Pose(13.500, 35.500);
    public static final Pose p2Control = new Pose(54.500, 37.000);
    public static final Pose p2End     = new Pose(56.000, 12.500);

    // Path 3 control points
    public static final Pose p3Start   = new Pose(56.000, 12.500);
    public static final Pose p3Control = new Pose(59.000, 65.000);
    public static final Pose p3End     = new Pose(13.000, 59.000);

    // Path 4 control points (reverse of Path 3)
    public static final Pose p4Start   = new Pose(13.000, 59.000);
    public static final Pose p4Control = new Pose(59.000, 65.000);
    public static final Pose p4End     = new Pose(56.000, 12.500);
}