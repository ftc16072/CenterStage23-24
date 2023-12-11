package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;
import org.firstinspires.ftc.teamcode.rr_trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.rr_trajectorysequence.TrajectorySequenceBuilder;

public class SetLeftSpikeToBackBoardTrajectory extends Node {
    public static final int FORWARD_DISTANCE_INCHES = 20;
    public static final int RIGHT_DISTANCE_INCHES = 5;

    @Override
    public State tick(QQOpMode opMode) {
        TrajectorySequenceBuilder builder = opMode.robot.nav.trajectorySequenceBuilder(opMode.robot.nav.getPoseEstimate());
        TrajectorySequence leftSpikeToParking = opMode.robot.nav.trajectorySequenceBuilder(new Pose2d(-39.53, -40.67, Math.toRadians(130.73)))
                .splineTo(new Vector2d(-31.33, -55.11), Math.toRadians(-31.81))
                .splineTo(new Vector2d(-6.89, -59.54), Math.toRadians(0.00))
                .splineTo(new Vector2d(64.29, -60.68), Math.toRadians(-0.92))
                .build();




        if (leftSpikeToParking== null){
            return State.FAILURE;
        }
        opMode.board.add("TrajectorySequence", leftSpikeToParking);
        return State.SUCCESS;
    }
}
