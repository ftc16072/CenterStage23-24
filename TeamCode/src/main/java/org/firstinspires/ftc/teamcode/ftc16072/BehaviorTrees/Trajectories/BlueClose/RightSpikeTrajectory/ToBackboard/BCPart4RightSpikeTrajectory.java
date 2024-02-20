package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.RightSpikeTrajectory.ToBackboard;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.BaseNodes.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;
import org.firstinspires.ftc.teamcode.ftc16072.Util.SpikePosition;
import org.firstinspires.ftc.teamcode.rr_trajectorysequence.TrajectorySequence;

public class BCPart4RightSpikeTrajectory extends Node {


    @Override
    public State tick(QQOpMode opMode) {
        TrajectorySequence turn = opMode.robot.nav.trajectorySequenceBuilder(opMode.robot.nav.getPoseEstimate())
                .turn(Math.toRadians(-80))
                .build();
        if (turn == null){
            return State.FAILURE;
        }
        opMode.board.add("TrajectorySequence", turn);
        opMode.board.add("SpikePosition", SpikePosition.MIDDLE);
        return State.SUCCESS;
    }
}
