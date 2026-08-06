package org.firstinspires.ftc.teamcode.Robot.Subsystems;

import com.arcrobotics.ftclib.command.Subsystem;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.MyTelemetry;
import org.firstinspires.ftc.teamcode.Robot.Robot;

public class Intake implements Subsystem {
    DcMotorEx intakeMotor;
    DcMotorEx transferMotor;
    public IntakeState intakeState = IntakeState.OFF;
    public Intake (DcMotorEx intakeMotor, DcMotorEx transferMotor) {
        this.intakeMotor = intakeMotor;
        this.transferMotor = transferMotor;


    }
    public void setState(Intake.IntakeState state) {
        this.intakeState = state;
        switch (state) {
            case OFF:
                intakeMotor.setPower(0);
                transferMotor.setPower(0);
                break;
            case ON:
                intakeMotor.setPower(0.8);
                transferMotor.setPower(0.8);

                break;
        }
    }
    @Override
    public void periodic(){
        MyTelemetry.addData("Intake State", intakeState);
    }
    public enum IntakeState {
        ON, OFF
    }
}
