package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trees;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.SetLeftSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.SetMiddleSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.IsLeftSpike;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.IsRightSpike;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Failover;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Sequence;

public class AutoBehaviorTree {
}/*
->
|  ?
|  |  ->
|  |  |  (IsLeftSpike)
|  |  |  [SetLeftSpikeTrajectory]
|  |  ->
|  |  |  (IsRightSpike)
|  |  |  [SetRightSpikeTrajectory]
|  |  [SetMiddleSpikeTrajectory]
|  [FollowTrajectory]
|  ?
|  |  ->  (isClose)
|  |  |
|  |  |  ?
|  |  |  |  ->(isRed)
|  |  |  |  |[SetRedCloseTrajectory]
|  |  |  |  [SetBlueCloseTrajectory]
|  |  ->  (isRed)
|  |  |  [SetRedFarTrajectory]
|  |  [SetBlueFarTrajectory]
|  [FollowTrajectory]
|  ?
|  |  -> (IsLeftSpike)
|  |  |  [SetLeftAprilTagTrajectory]
|  |  -> (IsRightSpike)
|  |  |  [SetRightAprilTagTrajectory]
|  |  [SetMiddleAprilTagTrajectory]
|  [FollowTrajectory]
|  [PlacePixel]
|  [CycleandPark]
*/
public class AutoTree{
    public static Node root(){
         new Sequence(
                 new Failover(
                         new Sequence(
                                 new IsLeftSpike(),
                                 new SetLeftSpikeTrajectory()
                         ),
                         new Sequence(
                                 new IsRightSpike(),
                                 new setRightSpikeTrajectory()
                         ),
                         new SetMiddleSpikeTrajectory

                 ),
                 new FollowTrajectory(),
                 new Failover(
                         new Sequence(
                                 new SetBlueFarTrajectory(),
                                 new IsRed(),
                                 new SetRedFarTrajectory()
                         )
                         new Sequence(
                                 new isClose(),
                                 new Failover(
                                         new SetBlueCloseTrajectory(),
                                         new Sequence(
                                                 new IsRed(),
                                                 new SetRedCloseTrajectory()
                                         )
                                 )
                         ),
                        new SetBlueTrajectory()
                         ),

                 )

         )

    }
}