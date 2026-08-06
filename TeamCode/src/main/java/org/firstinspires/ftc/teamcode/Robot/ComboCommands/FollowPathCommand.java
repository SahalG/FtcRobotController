package org.firstinspires.ftc.teamcode.Robot.ComboCommands;

import com.arcrobotics.ftclib.command.CommandBase;

import com.pedropathing.follower.Follower;
import com.pedropathing.localization.Pose;
import com.pedropathing.pathgen.Path;
import com.pedropathing.pathgen.PathChain;

public class FollowPathCommand extends CommandBase {
    private final Follower follower;
    private final PathChain path;

    public FollowPathCommand(Follower follower, PathChain path){
        this.follower = follower;
        this.path = path;
        ;}

    @Override
    public void initialize() {
        follower.followPath(path, true);
    }

    @Override
    public boolean isFinished() {
        return !follower.isBusy();
    }
}