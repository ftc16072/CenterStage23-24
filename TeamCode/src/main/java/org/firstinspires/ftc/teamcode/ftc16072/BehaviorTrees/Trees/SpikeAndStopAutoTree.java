package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trees;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.ReleaseAutoPixel;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.SpikeLocationTelemetry;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.Trajectories.FollowTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.IsLeftSpike;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.IsRightSpike;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.isAllianceBlueClose;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.isAllianceRedClose;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Failover;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Sequence;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.LeftSpike.BC1LeftSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.LeftSpike.BC2LeftSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.MiddleSpike.BC1MiddleSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.RightSpike.BC1RightSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.RightSpike.BC2RightSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.RedClose.LeftSpike.RC1LeftSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.RedClose.LeftSpike.RC2LeftSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.RedClose.MiddleSpike.RC1MiddleSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.RedClose.RightSpike.RC1RightSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.RedClose.RightSpike.RC2RightSpikeTrajectory;

public class SpikeAndStopAutoTree {
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
                //shows spike location telemetry
                new SpikeLocationTelemetry(),

                //check alliance, spike
                //set trajectory
                //go to tape
                new Failover(
                        new Sequence(
                                new isAllianceRedClose(),
                                //checks and sets trajectory for each spike position
                                //goes to tape
                                new Failover(
                                        new Sequence(
                                                new IsLeftSpike(),
                                                new RC1LeftSpikeTrajectory(),
                                                new FollowTrajectory(),
                                                new RC2LeftSpikeTrajectory(),
                                                new FollowTrajectory()

                                        ),
                                        new Sequence(
                                                new IsRightSpike(),
                                                new RC1RightSpikeTrajectory(),
                                                new FollowTrajectory(),
                                                new RC2RightSpikeTrajectory(),
                                                new FollowTrajectory()
                                        ),
                                        new Sequence(
                                                new RC1MiddleSpikeTrajectory(),
                                                new FollowTrajectory()
                                        )
                                )
                        ),

                        //check alliance
                        new Sequence(
                            //checks for alliance blue close
                            new isAllianceBlueClose(),
                            //checks for spike location
                            new Failover(

                                    //left spike tree
                                    new Sequence(
                                            new IsLeftSpike(),
                                            new BC1LeftSpikeTrajectory(),
                                            new FollowTrajectory(),
                                            new BC2LeftSpikeTrajectory(),
                                            new FollowTrajectory()

                                    ),

                                    //right spike tree
                                    new Sequence(
                                            new IsRightSpike(),
                                            new BC1RightSpikeTrajectory(),
                                            new FollowTrajectory(),
                                            new BC2RightSpikeTrajectory(),
                                            new FollowTrajectory()
                                    ),

                                    //middle spike tree
                                    new Sequence(
                                            new BC1MiddleSpikeTrajectory(),
                                            new FollowTrajectory()
                                    )

                            )
                        ),

                        new ReleaseAutoPixel()







/*
                        new Sequence(
                                //checks for alliance blue far
                                new isAllianceBlueFar(),
                                //checks for spike location
                                new Failover(

                                )
                        ),





                        new Sequence(
                                //checks for alliance red far
                                new isAllianceRedFar(),
                                //checks for spike location
                                new Failover(

                                )
                        )*/

                )
        );
    }




        /*
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

*/






}
