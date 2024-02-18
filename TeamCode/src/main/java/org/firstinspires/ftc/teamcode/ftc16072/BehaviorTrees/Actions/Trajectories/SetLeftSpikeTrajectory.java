package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.Trajectories;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;
import org.firstinspires.ftc.teamcode.ftc16072.Util.SpikePosition;
import org.firstinspires.ftc.teamcode.rr_trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.rr_trajectorysequence.TrajectorySequenceBuilder;

public class SetLeftSpikeTrajectory extends Node {
    public static final int FORWARD_DISTANCE_INCHES = 20;
    public static final int LEFT_DISTANCE_INCHES = 5;

    @Override
    public State tick(QQOpMode opMode) {
        TrajectorySequenceBuilder builder = opMode.robot.nav.trajectorySequenceBuilder(opMode.robot.nav.getPoseEstimate());
        TrajectorySequence sequence = builder.back(FORWARD_DISTANCE_INCHES).
                                            //strafeLeft(LEFT_DISTANCE_INCHES).
                                            //strafeRight(LEFT_DISTANCE_INCHES).
                                            forward(FORWARD_DISTANCE_INCHES).
                                            build();
        if (sequence == null){
            return State.FAILURE;
        }
        opMode.board.add("TrajectorySequence", sequence);
        opMode.board.add("SpikePosition", SpikePosition.LEFT);
        return State.SUCCESS;
    }
}
