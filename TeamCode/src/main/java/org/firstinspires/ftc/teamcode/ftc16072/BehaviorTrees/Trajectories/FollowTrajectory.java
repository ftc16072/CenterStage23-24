package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.BaseNodes.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;
import org.firstinspires.ftc.teamcode.rr_trajectorysequence.TrajectorySequence;

public class FollowTrajectory extends Node{
    boolean started;
    TrajectorySequence trajectorySequence;
    String trajectorySequenceString;

    @Override
    public State tick(QQOpMode opmode) {
        if(!started){
            trajectorySequence = opmode.board.get(TrajectorySequence.class, "TrajectorySequence");
            trajectorySequenceString = opmode.board.get(String.class, "TrajectorySequenceString");
            if(trajectorySequence == null){
                return State.FAILURE;
            }
            opmode.robot.nav.startNewTrajectorySequence(trajectorySequence);
            started = true;
        }
        else{

            opmode.robot.nav.update();
            if (!opmode.robot.nav.isBusy()){
                return State.SUCCESS;
            }
        }
        opmode.telemetry.addData("Current trajectory:",  trajectorySequence);


        return State.RUNNING;
    }
}
