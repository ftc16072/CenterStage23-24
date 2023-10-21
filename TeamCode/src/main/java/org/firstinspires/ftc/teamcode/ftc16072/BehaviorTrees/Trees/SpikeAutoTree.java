package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trees;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.FollowTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.SetLeftSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.SetMiddleSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.SetRightSpikeTrajectory;
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
                new Failover(
                        new Sequence(
                                new IsLeftSpike(),
                                new SetLeftSpikeTrajectory()
                        ),
                        new Sequence(
                                new IsRightSpike(),
                                new SetRightSpikeTrajectory()
                        ),
                        new SetMiddleSpikeTrajectory()
                ),
                new FollowTrajectory()
        );
    }
}
