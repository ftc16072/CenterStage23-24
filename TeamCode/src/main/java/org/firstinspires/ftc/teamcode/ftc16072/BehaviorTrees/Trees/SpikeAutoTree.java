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
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.isAllianceBlueClose;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.isAllianceBlueFar;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.isAllianceRedClose;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.isAllianceRedFar;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Failover;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Sequence;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.LeftSpike.BC1LeftSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.LeftSpike.BC2LeftSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.LeftSpike.BC3LeftSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.LeftSpike.BC4LeftSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.LeftSpike.BC5LeftSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.MiddleSpike.BC1MiddleSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.MiddleSpike.BC2MiddleSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.MiddleSpike.BC3MiddleSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.MiddleSpike.BC4MiddleSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.RightSpike.BC1RightSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.RightSpike.BC2RightSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.RightSpike.BC3RightSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.RightSpike.BC4RightSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.BlueClose.RightSpike.BC5RightSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.RedClose.LeftSpike.RC1LeftSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.RedClose.LeftSpike.RC2LeftSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.RedClose.LeftSpike.RC3LeftSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.RedClose.LeftSpike.RC4LeftSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.RedClose.LeftSpike.RC5LeftSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.RedClose.MiddleSpike.RC1MiddleSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.RedClose.MiddleSpike.RC2MiddleSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.RedClose.MiddleSpike.RC3MiddleSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.RedClose.MiddleSpike.RC4MiddleSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.RedClose.RightSpike.RC1RightSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.RedClose.RightSpike.RC2RightSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.RedClose.RightSpike.RC3RightSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.RedClose.RightSpike.RC4RightSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trajectories.RedClose.RightSpike.RC5RightSpikeTrajectory;

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
                                                //drive forwards
                                                new RC1LeftSpikeTrajectory(),
                                                new FollowTrajectory(),
                                                //strafe to tape
                                                new RC2LeftSpikeTrajectory(),
                                                new FollowTrajectory()

                                        ),
                                        new Sequence(
                                                new IsRightSpike(),
                                                //drive forwards
                                                new RC1RightSpikeTrajectory(),
                                                new FollowTrajectory(),
                                                //strafe to tape
                                                new RC2RightSpikeTrajectory(),
                                                new FollowTrajectory()
                                        ),
                                        new Sequence(
                                                //drive forwards
                                                new RC1MiddleSpikeTrajectory(),
                                                new FollowTrajectory()
                                        )
                                ),
                            new ReleaseAutoPixel(),
                                //set trajectory to backboard from tape location
                                new Failover(
                                        new Sequence(
                                                new IsLeftSpike(),
                                                new RC3LeftSpikeTrajectory(),
                                                new FollowTrajectory(),
                                                new RC4LeftSpikeTrajectory(),
                                                new FollowTrajectory()
                                        ),
                                        new Sequence(
                                                new IsRightSpike(),
                                                new RC3RightSpikeTrajectory(),
                                                new FollowTrajectory(),
                                                new RC4RightSpikeTrajectory(),
                                                new FollowTrajectory()
                                        ),
                                        new Sequence(
                                                new RC2MiddleSpikeTrajectory(),
                                                new FollowTrajectory(),
                                                new RC3MiddleSpikeTrajectory(),
                                                new FollowTrajectory()
                                        )
                                ),

                                //follow actions at backboard
                                //Adjust according to spike
                                new Failover(
                                        new Sequence(
                                                new IsLeftSpike(),
                                                new RC5LeftSpikeTrajectory(),
                                                new FollowTrajectory()

                                        ),
                                        new Sequence(
                                                new IsRightSpike(),
                                                new RC5RightSpikeTrajectory(),
                                                new FollowTrajectory()
                                        ),
                                        new Sequence(
                                                new RC4MiddleSpikeTrajectory(),
                                                new FollowTrajectory()
                                        )
                                )
                                //TODO ADd lift code
                                //TODO Add Pixel drop code
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
                                            //drive forwards
                                            new BC1LeftSpikeTrajectory(),
                                            new FollowTrajectory(),
                                            //strafe to tape
                                            new BC2LeftSpikeTrajectory(),
                                            new FollowTrajectory()

                                    ),

                                    //right spike tree
                                    new Sequence(
                                            new IsRightSpike(),
                                            //drive forwards
                                            new BC1RightSpikeTrajectory(),
                                            new FollowTrajectory(),
                                            //strafe to tape
                                            new BC2RightSpikeTrajectory(),
                                            new FollowTrajectory()
                                    ),

                                    //middle spike tree
                                    new Sequence(
                                            //drive forwards
                                            new BC1MiddleSpikeTrajectory(),
                                            new FollowTrajectory()
                                    )

                            ),
                                new ReleaseAutoPixel(),

                                //trajectory to backboard
                                new Failover(
                                        new Sequence(
                                                new IsLeftSpike(),
                                                new BC3LeftSpikeTrajectory(),
                                                new FollowTrajectory(),
                                                new BC4LeftSpikeTrajectory(),
                                                new FollowTrajectory()
                                        ),
                                        new Sequence(
                                                new IsRightSpike(),
                                                new BC3RightSpikeTrajectory(),
                                                new FollowTrajectory(),
                                                new BC4RightSpikeTrajectory(),
                                                new FollowTrajectory()
                                        ),
                                        new Sequence(
                                                new BC2MiddleSpikeTrajectory(),
                                                new FollowTrajectory(),
                                                new BC3MiddleSpikeTrajectory(),
                                                new FollowTrajectory()
                                        )
                                ),
                                //follow actions at backboard
                                //Adjust left/right according to spike
                                new Failover(
                                        new Sequence(
                                                new IsLeftSpike(),
                                                new BC5LeftSpikeTrajectory(),
                                                new FollowTrajectory()

                                        ),
                                        new Sequence(
                                                new IsRightSpike(),
                                                new BC5RightSpikeTrajectory(),
                                                new FollowTrajectory()
                                        ),
                                        new Sequence(
                                                new BC4MiddleSpikeTrajectory(),
                                                new FollowTrajectory()
                                        )
                                )
                            //TODO Add lift up code
                            //TODO Add pixel drop code

                        )







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
