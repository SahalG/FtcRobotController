package org.firstinspires.ftc.teamcode.Robot.Subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.Subsystem;
import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.MyTelemetry;
import org.firstinspires.ftc.teamcode.Robot.Robot;
@Config
public class Shooter implements Subsystem {

    private static final double TICKS_PER_REV = 28.0;

    DcMotorEx leftShooterMotor;
    DcMotorEx rightShooterMotor;
    PIDController shooterRPMPID;
    ElapsedTime dTime;
    public double power;
    public double avgRpm;
    public double targetSpeed;
    public ShooterState state = ShooterState.STOP;

    // Continuously-updated RPM values
    private double leftRpm = 0;
    private double rightRpm = 0;
    private final double scaleFactor = 200;
    public static double mathSpeed;

    public Shooter(DcMotorEx leftShooterMotor, DcMotorEx rightShooter) {
        this.leftShooterMotor = leftShooterMotor;
        this.rightShooterMotor = rightShooter;
        shooterRPMPID = new PIDController(1000, 0, 0);
        shooterRPMPID.setTolerance(10);
        dTime = new ElapsedTime();
    }

    public void setState(ShooterState state) {
        this.state = state;
        switch (state) {
            case STOP:
                leftShooterMotor.setPower(0);
                rightShooterMotor.setPower(0);
                targetSpeed = 0;
                break;
            case CLOSE:
                targetSpeed = 3000;

                break;
            case FAR:
                targetSpeed = 5000;

                break;
            case LINEAR:
                targetSpeed = Robot.distance * scaleFactor;

                break;
            case MATH:
                targetSpeed = mathSpeed;

        }
    }

    public void getRpm() {
        leftRpm = (leftShooterMotor.getVelocity() / TICKS_PER_REV) * 60.0;
        rightRpm = (rightShooterMotor.getVelocity() / TICKS_PER_REV) * 60.0;
    }

    public void setPower (double targetRpm) {
        shooterRPMPID.setPID(1000, 0, 0);
        avgRpm = (leftRpm + rightRpm) / 2;

        power = shooterRPMPID.calculate(avgRpm, targetRpm);
        power = Range.clip(power, 0, 1);

        leftShooterMotor.setPower(power);
        rightShooterMotor.setPower(power);

        MyTelemetry.addData("RPM", avgRpm);
        MyTelemetry.addData("Target RPM", targetRpm);
        MyTelemetry.addData("Power Output", power);
        MyTelemetry.addData("Shooter State", state);
    }

    @Override
    public void periodic() {
        setState(state);
        getRpm();
        setPower(targetSpeed);
    }

    public enum ShooterState {
        STOP, CLOSE, FAR, LINEAR, MATH
    }
}