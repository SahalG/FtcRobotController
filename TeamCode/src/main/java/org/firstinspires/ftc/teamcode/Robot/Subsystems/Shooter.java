package org.firstinspires.ftc.teamcode.Robot.Subsystems;

import static android.webkit.WebSettings.ZoomDensity.FAR;
import com.arcrobotics.ftclib.command.Subsystem;

import com.arcrobotics.ftclib.command.Subsystem;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Shooter implements Subsystem {
    DcMotor shooterMotor;
    public ShooterState state = ShooterState.STOP;
    public Shooter(DcMotor shooterMotor) {
        this.shooterMotor = shooterMotor;
    }
    public void setState(ShooterState state) {
        this.state = state;
        switch (state) {
            case STOP:
                shooterMotor.setPower(0);
                break;
            case CLOSE:
                shooterMotor.setPower(.5);
                break;
            case FAR:
                shooterMotor.setPower(.9);
                break;
        }
    }

    @Override
    public void periodic() {
        setState(state);
    }
    public enum ShooterState {
        STOP, CLOSE, FAR
    }

}
