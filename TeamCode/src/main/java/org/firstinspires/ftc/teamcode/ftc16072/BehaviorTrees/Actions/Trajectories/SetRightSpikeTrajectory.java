package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;
import org.firstinspires.ftc.teamcode.rr_trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.rr_trajectorysequence.TrajectorySequenceBuilder;

public class SetRightSpikeTrajectory extends Node {
    public static final int FORWARD_DISTANCE_INCHES = 20;
    public static final int RIGHT_DISTANCE_INCHES = 5;

    @Override
    public State tick(QQOpMode opMode) {
        TrajectorySequenceBuilder builder = opMode.robot.nav.trajectorySequenceBuilder(opMode.robot.nav.getPoseEstimate());
        TrajectorySequence rightParking = opMode.robot.nav.trajectorySequenceBuilder(new Pose2d(-36.90, -59.86, Math.toRadians(90.00)))
                .splineTo(new Vector2d(-30.01, -39.03), Math.toRadians(44.05))
                .build();


        if (rightParking == null){
            return State.FAILURE;
        }
        opMode.board.add("TrajectorySequence", rightParking);
        return State.SUCCESS;
    }
}
