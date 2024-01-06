package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.Trajectories;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;
import org.firstinspires.ftc.teamcode.rr_trajectorysequence.TrajectorySequence;

public class FollowTrajectory extends Node{
    boolean started;

    @Override
    public State tick(QQOpMode opmode) {
        if(!started){
            TrajectorySequence trajectorySequence = opmode.board.get(TrajectorySequence.class, "TrajectorySequence");
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
        return State.RUNNING;
    }
}
