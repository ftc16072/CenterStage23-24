package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trees;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.ReleaseAutoPixel;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.SpikeLocationTelemetry;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.Trajectories.FollowTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.Trajectories.LeftSpikeTrajectory.Spike.SetLeftSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.Trajectories.LeftSpikeTrajectory.Spike.SetLeftSpikeTrajectoryPart2;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.Trajectories.LeftSpikeTrajectory.ToBackboard.SetLeftSpikeTrajectoryPart3;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.Trajectories.MiddleSpikeTrajectory.Spike.SetMiddleSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.Trajectories.MiddleSpikeTrajectory.ToBackboard.SetMiddleSpikeTrajectoryPart2;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.Trajectories.RightSpikeTrajectory.Spike.SetRightSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.Trajectories.RightSpikeTrajectory.Spike.SetRightSpikeTrajectoryPart2;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.Trajectories.RightSpikeTrajectory.ToBackboard.SetRightSpikeTrajectoryPart3;
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
    public static Node root() {
        return new Sequence(
                //shows spike location
                new SpikeLocationTelemetry(),
                //checks and sets trajectory for each spike position
                //goes to tape
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
                new Failover(
                        new Sequence(
                                new IsLeftSpike(),
                                new SetLeftSpikeTrajectoryPart3(),
                                new FollowTrajectory()
                        ),
                        new Sequence(
                                new IsRightSpike(),
                                new SetRightSpikeTrajectoryPart3(),
                                new FollowTrajectory()
                        ),
                        new Sequence(
                                new SetMiddleSpikeTrajectoryPart2(),
                                new FollowTrajectory()
                        )
                ),
                //follow backboard trajectory
                new FollowTrajectory()

        );
    }
}
