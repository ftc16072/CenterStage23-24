package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.RedClose.MiddleSpikeTrajectory.ToBackboard;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.BaseNodes.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;
import org.firstinspires.ftc.teamcode.ftc16072.Util.SpikePosition;
import org.firstinspires.ftc.teamcode.rr_trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.rr_trajectorysequence.TrajectorySequenceBuilder;

public class RCPart2MiddleSpikeTrajectory extends Node {
    public static final int RIGHT_DISTANCE_INCHES = 39;


    @Override
    public State tick(QQOpMode opMode) {
        TrajectorySequenceBuilder builder = opMode.robot.nav.trajectorySequenceBuilder(opMode.robot.nav.getPoseEstimate());
        TrajectorySequence sequence = builder
                .strafeRight(RIGHT_DISTANCE_INCHES).
                build();
        if (sequence == null){
            return State.FAILURE;
        }
        opMode.board.add("TrajectorySequence", sequence);
        opMode.board.add("SpikePosition", SpikePosition.MIDDLE);
        return State.SUCCESS;
    }
}
