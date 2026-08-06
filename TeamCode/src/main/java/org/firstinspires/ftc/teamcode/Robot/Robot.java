package org.firstinspires.ftc.teamcode.Robot;

import com.arcrobotics.ftclib.command.CommandScheduler;
import com.pedropathing.follower.Follower;
import com.pedropathing.localization.Pose;
import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Robot.Subsystems.Blocker;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.Intake;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.Shooter;
import org.firstinspires.ftc.teamcode.pedroPathing.constants.LConstants;
import org.firstinspires.ftc.teamcode.pedroPathing.constants.FConstants;

import org.firstinspires.ftc.teamcode.MyTelemetry;

import java.util.List;

public class Robot {
    private static ElapsedTime elapsedTime;
    public List<LynxModule> hubs;


    public double loopTime;
    public static Follower follower;
    public float Hz;
    public double xDistance;
    public double yDistance;
    public static double distance;
    DcMotorEx leftShooterMotor;
    DcMotorEx rightShooterMotor;
    DcMotorEx intakeMotor;
    DcMotorEx transferMotor;
    Servo blockerServo;

    public Shooter shooter;
    public Intake intake;
    public Blocker blocker;

    public Robot (HardwareMap hardwareMap) {
        CommandScheduler.getInstance().reset();
        follower = new Follower(hardwareMap, FConstants.class, LConstants.class);
        elapsedTime = new ElapsedTime();
        elapsedTime.reset();
        leftShooterMotor = hardwareMap.get(DcMotorEx.class, "launcher");
        leftShooterMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        leftShooterMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        rightShooterMotor = hardwareMap.get(DcMotorEx.class, "launcher2");
        rightShooterMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rightShooterMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        intakeMotor = hardwareMap.get(DcMotorEx.class, "intakeMotor");
        intakeMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        transferMotor = hardwareMap.get(DcMotorEx.class, "transferMotor");
        transferMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        blockerServo = hardwareMap.get(Servo.class, "blockerServo");
        blockerServo.setDirection(Servo.Direction.FORWARD);

        shooter = new Shooter(leftShooterMotor, rightShooterMotor);
        intake = new Intake(intakeMotor, transferMotor);
        blocker = new Blocker(blockerServo);

        hubs = hardwareMap.getAll(LynxModule.class);
        for (LynxModule hub : hubs) {
            hub.setBulkCachingMode(LynxModule.BulkCachingMode.MANUAL);
        }
        CommandScheduler.getInstance().registerSubsystem(intake, blocker, shooter);
        follower.setStartingPose(new Pose(0, 0, 0));
    }

    public void update () {

        CommandScheduler.getInstance().run();
        for(LynxModule hub : hubs){
            hub.clearBulkCache();
        }
        xDistance = follower.getPose().getX();
        yDistance = 144 - follower.getPose().getY();

        distance = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));

        loopTime = elapsedTime.milliseconds();
        Hz = (float) (1000/loopTime);
        MyTelemetry.addData("Loop Time", loopTime);
        MyTelemetry.addData("Hz", Hz);
        MyTelemetry.addData("Distance", distance);
        MyTelemetry.update();
        elapsedTime.reset();
        follower.update();
    }

    public void holdPose(){
        follower.holdPoint(follower.getPose());
    }

    public void breakFollowing(){
        follower.breakFollowing();
    }
}
