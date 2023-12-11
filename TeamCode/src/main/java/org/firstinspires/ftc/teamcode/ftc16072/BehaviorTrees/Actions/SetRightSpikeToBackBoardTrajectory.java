package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;
import org.firstinspires.ftc.teamcode.rr_trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.rr_trajectorysequence.TrajectorySequenceBuilder;

public class SetRightSpikeToBackBoardTrajectory extends Node {
    public static final int FORWARD_DISTANCE_INCHES = 20;
    public static final int RIGHT_DISTANCE_INCHES = 5;

    @Override
    public State tick(QQOpMode opMode) {
        TrajectorySequenceBuilder builder = opMode.robot.nav.trajectorySequenceBuilder(opMode.robot.nav.getPoseEstimate());
        TrajectorySequence rightSpikeToParking = opMode.robot.nav.trajectorySequenceBuilder(new Pose2d(-29.19, -35.26, Math.toRadians(55.76)))
                .splineTo(new Vector2d(-33.95, -53.47), Math.toRadians(-56.15))
                .splineTo(new Vector2d(-22.47, -59.86), Math.toRadians(-2.57))
                .splineTo(new Vector2d(59.70, -60.36), Math.toRadians(-1.08))
                .build();



        if (rightSpikeToParking == null){
            return State.FAILURE;
        }
        opMode.board.add("TrajectorySequence", rightSpikeToParking);
        return State.SUCCESS;
    }
}
