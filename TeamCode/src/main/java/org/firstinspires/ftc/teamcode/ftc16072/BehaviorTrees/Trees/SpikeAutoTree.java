package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trees;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.SpikeLocationTelemetry;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.ReleaseAutoPixel;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.isAllianceBlueClose;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.isAllianceRedClose;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.FollowTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.LeftSpikeTrajectory.AtBackboard.BCPart5LeftSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.LeftSpikeTrajectory.Spike.BCPart1LeftSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.LeftSpikeTrajectory.Spike.BCPart2LeftSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.LeftSpikeTrajectory.ToBackboard.BCPart3LeftSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.LeftSpikeTrajectory.ToBackboard.BCPart4LeftSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.MiddleSpikeTrajectory.AtBackboard.BCPart4MiddleSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.MiddleSpikeTrajectory.ToBackboard.BCPart2MiddleSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.MiddleSpikeTrajectory.ToBackboard.BCPart3MiddleSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.RightSpikeTrajectory.AtBackboard.BCPart5RightSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.RightSpikeTrajectory.Spike.BCPart2RightSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.MiddleSpikeTrajectory.Spike.BCPart1MiddleSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.RightSpikeTrajectory.Spike.BCPart1RightSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.RightSpikeTrajectory.ToBackboard.BCPart3RightSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.RightSpikeTrajectory.ToBackboard.BCPart4RightSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.IsLeftSpike;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.IsRightSpike;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.BaseNodes.Failover;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.BaseNodes.Node;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.BaseNodes.Sequence;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.RedClose.LeftSpikeTrajectory.AtBackboard.RCPart5LeftSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.RedClose.LeftSpikeTrajectory.Spike.RCPart1LeftSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.RedClose.LeftSpikeTrajectory.Spike.RCPart2LeftSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.RedClose.LeftSpikeTrajectory.ToBackboard.RCPart3LeftSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.RedClose.LeftSpikeTrajectory.ToBackboard.RCPart4LeftSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.RedClose.MiddleSpikeTrajectory.AtBackboard.RCPart4MiddleSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.RedClose.MiddleSpikeTrajectory.Spike.RCPart1MiddleSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.RedClose.MiddleSpikeTrajectory.ToBackboard.RCPart2MiddleSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.RedClose.MiddleSpikeTrajectory.ToBackboard.RCPart3MiddleSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.RedClose.RightSpikeTrajectory.AtBackboard.RCPart5RightSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.RedClose.RightSpikeTrajectory.Spike.RCPart1RightSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.RedClose.RightSpikeTrajectory.Spike.RCPart2RightSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.RedClose.RightSpikeTrajectory.ToBackboard.RCPart3RightSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.RedClose.RightSpikeTrajectory.ToBackboard.RCPart4RightSpikeTrajectory;

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
                //sets red/blue, close/far
                new Failover(
                    //Sets BlueClose
                    new Sequence(
                            new isAllianceBlueClose(),
                            //checks and sets trajectory for each spike position
                            //goes to tape
                            new Failover(
                                    new Sequence(
                                            new IsLeftSpike(),
                                            new BCPart1LeftSpikeTrajectory(),
                                            new FollowTrajectory(),
                                            new BCPart2LeftSpikeTrajectory(),
                                            new FollowTrajectory()

                                    ),
                                    new Sequence(
                                            new IsRightSpike(),
                                            new BCPart1RightSpikeTrajectory(),
                                            new FollowTrajectory(),
                                            new BCPart2RightSpikeTrajectory(),
                                            new FollowTrajectory()
                                    ),
                                    new Sequence(
                                        new BCPart1MiddleSpikeTrajectory(),
                                        new FollowTrajectory()
                                    )
                            ),

                            //Move servo to release purple pixel
                            new ReleaseAutoPixel(),
                            //set trajectory to backboard from tape location
                            new Failover(
                                    new Sequence(
                                            new IsLeftSpike(),
                                            new BCPart3LeftSpikeTrajectory(),
                                            new FollowTrajectory(),
                                            new BCPart4LeftSpikeTrajectory(),
                                            new FollowTrajectory()
                                    ),
                                    new Sequence(
                                            new IsRightSpike(),
                                            new BCPart3RightSpikeTrajectory(),
                                            new FollowTrajectory(),
                                            new BCPart4RightSpikeTrajectory(),
                                            new FollowTrajectory()
                                    ),
                                    new Sequence(
                                            new BCPart2MiddleSpikeTrajectory(),
                                            new FollowTrajectory(),
                                            new BCPart3MiddleSpikeTrajectory(),
                                            new FollowTrajectory()
                                    )
                            ),

                            //follow actions at backboard
                            //Adjust left/right according to spike
                            new Failover(
                                    new Sequence(
                                            new IsLeftSpike(),
                                            new BCPart5LeftSpikeTrajectory(),
                                            new FollowTrajectory()

                                    ),
                                    new Sequence(
                                            new IsRightSpike(),
                                            new BCPart5RightSpikeTrajectory(),
                                            new FollowTrajectory()
                                    ),
                                    new Sequence(
                                            new BCPart4MiddleSpikeTrajectory(),
                                            new FollowTrajectory()
                                    )
                            )
                    ),
                    //red close
                    new Sequence(
                            new isAllianceRedClose(),
                                    //checks and sets trajectory for each spike position
                                    //goes to tape
                                    new Failover(
                                            new Sequence(
                                                    new IsLeftSpike(),
                                                    new RCPart1LeftSpikeTrajectory(),
                                                    new FollowTrajectory(),
                                                    new RCPart2LeftSpikeTrajectory(),
                                                    new FollowTrajectory()

                                            ),
                                            new Sequence(
                                                    new IsRightSpike(),
                                                    new RCPart1RightSpikeTrajectory(),
                                                    new FollowTrajectory(),
                                                    new RCPart2RightSpikeTrajectory(),
                                                    new FollowTrajectory()
                                            ),
                                            new Sequence(
                                                    new RCPart1MiddleSpikeTrajectory(),
                                                    new FollowTrajectory()
                                            )
                                    ),

                                    //Move servo to release purple pixel
                                    new ReleaseAutoPixel(),
                                    //set trajectory to backboard from tape location
                                    new Failover(
                                            new Sequence(
                                                    new IsLeftSpike(),
                                                    new RCPart3LeftSpikeTrajectory(),
                                                    new FollowTrajectory(),
                                                    new RCPart4LeftSpikeTrajectory(),
                                                    new FollowTrajectory()
                                            ),
                                            new Sequence(
                                                    new IsRightSpike(),
                                                    new RCPart3RightSpikeTrajectory(),
                                                    new FollowTrajectory(),
                                                    new RCPart4RightSpikeTrajectory(),
                                                    new FollowTrajectory()
                                            ),
                                            new Sequence(
                                                    new RCPart2MiddleSpikeTrajectory(),
                                                    new FollowTrajectory(),
                                                    new RCPart3MiddleSpikeTrajectory(),
                                                    new FollowTrajectory()
                                            )
                                    ),

                                    //follow actions at backboard
                                    //Adjust according to spike
                                    new Failover(
                                            new Sequence(
                                                    new IsLeftSpike(),
                                                    new RCPart5LeftSpikeTrajectory(),
                                                    new FollowTrajectory()

                                            ),
                                            new Sequence(
                                                    new IsRightSpike(),
                                                    new RCPart5RightSpikeTrajectory(),
                                                    new FollowTrajectory()
                                            ),
                                            new Sequence(
                                                    new RCPart4MiddleSpikeTrajectory(),
                                                    new FollowTrajectory()
                                            )
                                    )

                    )
                    //blue far
                    //red far
                )
        );
    }
}
