package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;
import org.firstinspires.ftc.teamcode.rr_trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.rr_trajectorysequence.TrajectorySequenceBuilder;

public class SetMiddleSpikeTrajectory extends Node {
    public static final int FORWARD_DISTANCE_INCHES = 20;
    TrajectorySequence Middle;
    @Override
    public State tick(QQOpMode opMode) {
        TrajectorySequenceBuilder builder = opMode.robot.nav.trajectorySequenceBuilder(opMode.robot.nav.getPoseEstimate());

        TrajectorySequence middleParking = opMode.robot.nav.trajectorySequenceBuilder(new Pose2d(-36.90, -62.65, Math.toRadians(90.00)))
                .splineTo(new Vector2d(-36.57, -33.62), Math.toRadians(88.50))
                .build();


        if (middleParking == null){
            return State.FAILURE;
        }
        opMode.board.add("TrajectorySequence", middleParking);
        return State.SUCCESS;
    }
}
