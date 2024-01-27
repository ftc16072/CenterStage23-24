package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trees;

public class CycleandPark {
}
/*
->
|  ? (enoughTimeForCycle)
|  | (isParked)
|  |  -> (isRed)
|  |  |  [setRedParkTrajectory]
|  |  -> !(isRed)
|  |  |  [setBlueParkTrajectory]
|  | -> [FollowTrajectory]
|  -> !(isParked)
|  |  ?
|  |  | -> (isRed)
|  |  |  |  ?
|  |  |  |  | -> (isLeftSpike)
|  |  |  |  |  | [setRedLeftTrajectory]
|  |  |  |  | -> (isRightSpike)
|  |  |  |  |  | [setRedRightTrajectory]
|  |  |  |  |  [setRedMiddleTrajectory]
|  |  |  ->
|  |  |  |  (isLeftSpike)
|  |  |  |  [setBlueLeftTrajectory]
|  |  |  -> (isRightSpike)
|  |  |  |  [setBlueRightTrajectory]
|  |  |  [setBlueMiddleTrajectory]
|  |  [FollowTrajectory]
|  |  ? (has2Pixels)
|  |  |  [intakePixel]
|  |  ?
|  |  |  ->  (isRed)
|  |  |  | [setRedPlacingTrajectory]
|  |  |  [setBluePlacingTrajectory]
|  |  [FollowTrajectory]
 */
//