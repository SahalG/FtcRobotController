package org.firstinspires.ftc.teamcode.Constants;

import com.pedropathing.localization.Pose;

public class AutoConstants {
        public static final Pose startPose = new Pose(22, 124, Math.toRadians(143));


        // ================= Chain 1 =================
        // Simple line, no control point
        public static final Pose startPointOne = new Pose(22.000, 124.000);
        public static final Pose endPointOne = new Pose(50.000, 100.000);
        public static final double startHeadingOne = Math.toRadians(143);
        public static final double endHeadingOne = Math.toRadians(135);

        // ================= Chain 2 =================
        // Curve out to endPointTwo, then curve back to startPointTwo
        public static final Pose startPointTwo = new Pose(24.000, 82.500);
        public static final Pose controlPointTwo = new Pose(50.000, 81.500);
        public static final Pose endPointTwo = new Pose(50.000, 100.000);
        public static final double startHeadingTwo = Math.toRadians(180);
        public static final double endHeadingTwo = Math.toRadians(135);

        // ================= Chain 3 =================
        // Curve out to endPointThree, then curve back to startPointThree
        public static final Pose startPointThree = new Pose(50.000, 100.000);
        public static final Pose controlPointThree = new Pose(50.000, 57.500);
        public static final Pose endPointThree = new Pose(24.000, 58.500);
        public static final double startHeadingThree = Math.toRadians(135);
        public static final double endHeadingThree = Math.toRadians(180);

        // ================= Chain 4 =================
        // Curve out to endPointFour, then curve back to startPointFour
        public static final Pose startPointFour = new Pose(50.000, 100.000);
        public static final Pose controlPointFour = new Pose(50.000, 32.500);
        public static final Pose endPointFour = new Pose(24.000, 34.500);
        public static final double startHeadingFour = Math.toRadians(135);
        public static final double endHeadingFour = Math.toRadians(180);



    }
