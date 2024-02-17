package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trees;

import org.checkerframework.checker.units.qual.A;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.SpikeLocationTelemetry;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.PlacePurplePixel;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.ReleaseAutoPixel;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.SetBackboardFromSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.SpikeLocationTelemetry;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.Trajectories.FollowTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.Trajectories.SetLeftSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.Trajectories.SetMiddleSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.Trajectories.SetRightSpikeTrajectory;
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
                                new SetLeftSpikeTrajectory()
                        ),
                        new Sequence(
                                new IsRightSpike(),
                                new SetRightSpikeTrajectory()
                        ),
                        new SetMiddleSpikeTrajectory()
                ),

                //follows trajectory set based on spike location
                new FollowTrajectory(),
                //Move servo to release purple pixel
                new ReleaseAutoPixel(),
                //set trajectory to backboard from tape location
                new SetBackboardFromSpikeTrajectory(),
                //follow backboard trajectory
                new FollowTrajectory()

        );
    }
}
