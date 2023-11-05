package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trees;

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