package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;
import org.firstinspires.ftc.teamcode.rr_trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.rr_trajectorysequence.TrajectorySequenceBuilder;

public class SetMiddleSpikeToBackBoardTrajectory extends Node {
    public static final int FORWARD_DISTANCE_INCHES = 20;
    public static final int RIGHT_DISTANCE_INCHES = 5;

    @Override
    public State tick(QQOpMode opMode) {
        TrajectorySequenceBuilder builder = opMode.robot.nav.trajectorySequenceBuilder(opMode.robot.nav.getPoseEstimate());
        TrajectorySequence middleSpikeToParkingTrajectory = opMode.robot.nav.trajectorySequenceBuilder(new Pose2d(-36.25, -37.72, Math.toRadians(92.49)))
                .splineTo(new Vector2d(-36.74, -57.73), Math.toRadians(-12.77))
                .splineTo(new Vector2d(-3.61, -59.54), Math.toRadians(-3.12))
                .splineTo(new Vector2d(61.34, -60.52), Math.toRadians(-0.40))
                .build();




        if (middleSpikeToParkingTrajectory== null){
            return State.FAILURE;
        }
        opMode.board.add("TrajectorySequence", middleSpikeToParkingTrajectory);
        return State.SUCCESS;
    }
}
