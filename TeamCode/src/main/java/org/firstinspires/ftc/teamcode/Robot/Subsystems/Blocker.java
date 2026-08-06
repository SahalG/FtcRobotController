package org.firstinspires.ftc.teamcode.Robot.Subsystems;

import com.arcrobotics.ftclib.command.Subsystem;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.MyTelemetry;
import org.firstinspires.ftc.teamcode.Robot.Robot;

public class Blocker implements Subsystem {
    Servo blockerServo;

    public BlockerState blockerState = BlockerState.CLOSED;
    public Blocker (Servo blockerServo) {
        this.blockerServo = blockerServo;
    }
    public void setState(Blocker.BlockerState state) {
        this.blockerState = state;
        switch (state) {
            case CLOSED:
                    blockerServo.setPosition(0);
                break;
            case OPEN:
                    blockerServo.setPosition(0.5);

                break;
        }
    }
    @Override
    public void periodic(){
        MyTelemetry.addData("Blocker State", blockerState);
    }
    public enum BlockerState {
        CLOSED, OPEN
    }
}
