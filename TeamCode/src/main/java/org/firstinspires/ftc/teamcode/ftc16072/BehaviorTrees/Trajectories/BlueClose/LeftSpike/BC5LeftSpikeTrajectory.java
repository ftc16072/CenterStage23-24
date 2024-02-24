package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.LeftSpike;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;
import org.firstinspires.ftc.teamcode.ftc16072.Util.SpikePosition;
import org.firstinspires.ftc.teamcode.rr_trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.rr_trajectorysequence.TrajectorySequenceBuilder;

public class BC5LeftSpikeTrajectory extends Node {
    public static final int FORWARD_DISTANCE_INCHES=7;

    @Override
    public State tick(QQOpMode opMode) {
        TrajectorySequenceBuilder builder = opMode.robot.nav.trajectorySequenceBuilder(opMode.robot.nav.getPoseEstimate());
        TrajectorySequence sequence = builder.strafeRight(FORWARD_DISTANCE_INCHES).
                build();
        if (sequence == null){
            return State.FAILURE;
        }
        opMode.board.add("TrajectorySequence", sequence);
        opMode.board.add("SpikePosition", SpikePosition.LEFT);
        return State.SUCCESS;
    }
}
