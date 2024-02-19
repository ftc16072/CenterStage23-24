package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trees;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.SpikeLocationTelemetry;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.ReleaseAutoPixel;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.SetBackboardFromSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.Trajectories.FollowTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.Trajectories.LeftSpikeTrajectory.SetLeftSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.Trajectories.LeftSpikeTrajectory.SetLeftSpikeTrajectoryPart2;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.Trajectories.RightSpikeTrajectory.SetRightSpikeTrajectoryPart2;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.Trajectories.SetMiddleSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.Trajectories.RightSpikeTrajectory.SetRightSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.IsLeftSpike;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.IsRightSpike;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Failover;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Sequence;

public class SpikeAutoTree {
/*
->
|    ?
|    |    ->
|    |    |   (IsLeftSpike)
|    |    |   [SetLeftSpikeTrajectory]
|    |    ->
|    |    |   (IsRightSpike)
|    |    |   [SetRightSpikeTrajectory]
|    |    [SetMiddleSpikeTrajectory]
|    [FollowTrajectory]
 */
    public static Node root(){
        return new Sequence(
                //shows spike location
                new SpikeLocationTelemetry(),
                //checks and sets trajectory for each spike position
                new Failover(
                        new Sequence(
                                new IsLeftSpike(),
                                new SetLeftSpikeTrajectory(),
                                new FollowTrajectory(),
                                new SetLeftSpikeTrajectoryPart2(),
                                new FollowTrajectory()

                        ),
                        new Sequence(
                                new IsRightSpike(),
                                new SetRightSpikeTrajectory(),
                                new FollowTrajectory(),
                                new SetRightSpikeTrajectoryPart2(),
                                new FollowTrajectory()
                        ),
                        new Sequence(
                            new SetMiddleSpikeTrajectory(),
                            new FollowTrajectory()
                        )
                ),

                //Move servo to release purple pixel
                new ReleaseAutoPixel(),
                //set trajectory to backboard from tape location
                new SetBackboardFromSpikeTrajectory(),
                //follow backboard trajectory
                new FollowTrajectory()

        );
    }
}
