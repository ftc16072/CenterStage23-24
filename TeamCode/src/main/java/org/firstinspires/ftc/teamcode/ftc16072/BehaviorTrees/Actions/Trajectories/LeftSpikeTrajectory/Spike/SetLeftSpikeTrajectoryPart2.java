package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.Trajectories.LeftSpikeTrajectory.Spike;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;
import org.firstinspires.ftc.teamcode.ftc16072.Util.SpikePosition;
import org.firstinspires.ftc.teamcode.rr_trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.rr_trajectorysequence.TrajectorySequenceBuilder;

public class SetLeftSpikeTrajectoryPart2 extends Node {

    public static final int LEFT_DISTANCE_INCHES = 8;

    @Override
    public State tick(QQOpMode opMode) {
        TrajectorySequenceBuilder builder = opMode.robot.nav.trajectorySequenceBuilder(opMode.robot.nav.getPoseEstimate());
        TrajectorySequence sequence = builder
                //right because robot is facing backward
                .strafeRight(LEFT_DISTANCE_INCHES)
                .build();
        if (sequence == null){
            return State.FAILURE;
        }
        opMode.board.add("TrajectorySequence", sequence);
        opMode.board.add("TrajectorySequenceString", "Left Spike Trajectory 2");

        opMode.board.add("SpikePosition", SpikePosition.LEFT);
        return State.SUCCESS;
    }
}
