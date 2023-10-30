package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trees;

public class CycleandPark {
}
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