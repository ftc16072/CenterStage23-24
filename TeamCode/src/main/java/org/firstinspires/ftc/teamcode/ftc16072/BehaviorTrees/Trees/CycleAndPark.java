package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trees;
/*
->
|  ? (enoughTimeForCycle)
|  |  -> (isRed)
|  |  |  ?
|  |  |  | -> (isLocationIntake)
|  |  |  |  | [setRedIntakeParkTrajectory]
|  |  |  | -> (isLocationPlacing)
|  |  |  |  | [setRedPlacingParkTrajectory]
|  |  -> !(isRed)
|  |  |  ?
|  |  |  | -> (isLocationIntake)
|  |  |  |  | [setBlueIntakeParkTrajectory]
|  |  |  | -> (isLocationPlacing)
|  |  |  |  | [setBluePlacingParkTrajectory]
|  | -> [FollowTrajectory]
|  ?
|  | -> (isRed)
|  |  |  ?
|  |  |  | -> (isLeftSpike)
|  |  |  |  | [setRedLeftTrajectory]
|  |  |  | -> (isRightSpike)
|  |  |  |  | [setRedRightTrajectory]
|  |  |  |  [setRedMiddleTrajectory]
|  |  ->
|  |  |  (isLeftSpike)
|  |  |  [setRedLeftTrajectory]
|  |  -> (isRightSpike)
|  |  |  [setRedRightTrajectory]
|  |  [setRedMiddleTrajectory]
|  [followTrajectory]
|  [setLocationIntake]
|  ? (has2Pixels)
|  |  [intakePixel]
|  ?
|  |  ->  (isRed)
|  |  | [setRedPlacingTrajectory]
|  |  [setBluePlacingTrajectory]
|  [followTrajectory]
|  [setLocationPlacing] */

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Sequence;

public class CycleAndPark {
    public static Node root() {
        return new Sequence(
                /*
                  new Failover(
                          new EnoughTimeForCycle(),
                          new Sequence(
                                  new isRed(),
                                  new Failover(
                                          new Sequence(
                                                  new isLocationIntake(),
                                                  new setRedIntakeParkTrajectory()
                                          ),
                                          new Sequence(
                                                  new isLocationPlacing(),
                                                  new setRedPlacingParkTrajectory()
                                          )
                                  )
                          ),
                          new Sequence (
                                  new notIsRed (),
                                  new Failover(
                                          new Sequence (
                                                  new isLocationIntake(),
                                                  new setBlueIntakeParkTrajectory()
                                          ),
                                          new Sequence (
                                                  new isLocationPlacing(),
                                                  new setBluePlacingParkTrajectory()

                                          )


                                  )
                          ),

                         new Sequence(
                                 new FollowTrajectory()
                         )




                ),
                new Failover(
                        new Sequence(
                                new isRed(),
                                new Failover(
                                        new Sequence(
                                                new isLeftSpike(),
                                                new setRedLeftTrajectory()
                                        ),
                                        new Sequence(
                                                new isRedSpike(),
                                                new setRedTrajectory()
                                        ),
                                        new setRedMiddleTrajectory
                                )
                        ),
                        new Sequence(
                                new isLeftSpike(),
                                new setRedLeftTrajectory()
                        ),
                        new Sequence(
                           new isRightSpike(),
                           new setRedRightTrajectory()
                        ),
                        new setRedMiddleTrajectory()



                new followTrajectory(),
                new setLocationIntake(),
                new Failover(
                        new has2Pixels(),
                        new intakePixel()
                ),
                new Failover(
                        new Sequence(
                                new isRed(),
                                new setRedPlacingTrajectory()
                        ),
                        new setBluePlacingTrajectory()
                ),
                new followTrajectory(),
                new setLocationPlacing()
        )
        */
        );
    }

}
