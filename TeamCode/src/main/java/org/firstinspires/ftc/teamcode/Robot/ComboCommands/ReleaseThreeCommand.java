package org.firstinspires.ftc.teamcode.Robot.ComboCommands;


import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Robot.Commands.IntakeCommand;
import org.firstinspires.ftc.teamcode.Robot.Robot;
import org.firstinspires.ftc.teamcode.Robot.Commands.BlockerCommand;
import org.firstinspires.ftc.teamcode.Robot.Commands.ShooterCommand;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.Blocker;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.Intake;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.Shooter;


public class ReleaseThreeCommand extends SequentialCommandGroup {
    public ReleaseThreeCommand(Robot robot) {
        addCommands(
            new BlockerCommand(robot, Blocker.BlockerState.OPEN),
            new WaitCommand(200),
            new IntakeCommand(robot, Intake.IntakeState.ON),
            new WaitCommand(2500),
            new IntakeCommand(robot, Intake.IntakeState.OFF),
            new BlockerCommand(robot, Blocker.BlockerState.CLOSED)

        );

    }}
