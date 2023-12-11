package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;
import org.firstinspires.ftc.teamcode.rr_trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.rr_trajectorysequence.TrajectorySequenceBuilder;

public class SetLeftSpikeTrajectory extends Node {
    public static final int FORWARD_DISTANCE_INCHES = 20;
    public static final int LEFT_DISTANCE_INCHES = 5;

    @Override
    public State tick(QQOpMode opMode) {
        TrajectorySequenceBuilder builder = opMode.robot.nav.trajectorySequenceBuilder(opMode.robot.nav.getPoseEstimate());
        TrajectorySequence leftParking = opMode.robot.nav.trajectorySequenceBuilder(new Pose2d(-36.57, -61.50, Math.toRadians(90.00)))
                .splineTo(new Vector2d(-43.13, -39.69), Math.toRadians(132.71))
                .build();

        if (leftParking == null){
            return State.FAILURE;
        }
        opMode.board.add("TrajectorySequence", leftParking);
        return State.SUCCESS;
    }
}
