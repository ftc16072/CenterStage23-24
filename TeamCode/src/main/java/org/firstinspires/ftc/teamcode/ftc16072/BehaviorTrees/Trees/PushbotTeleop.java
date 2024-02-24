package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trees;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.DriveFieldRelative;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.ResetGyro;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.UpdateClimber;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.UpdateIntake;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Parallel;

/*
http://behaviortrees.ftcteams.com/

=4
| ->
| | (IsEndGame)
| | =2
| | | ->
| | | | ?
| | | | | (IsLastThreeSeconds)
| | | | | ->
| | | | | | (IsDroneLocation)
| | | | | | (IsDroneButtonPressed)
| | | | (HaveNotLaunchedDrone)
| | | | [LaunchDrone]

| | | ->
| | | | (IsClimbLocation)
| | | | (IsClimbButtonPressed)
| | | | [Climb]

| ?
| | ->
| | | (HasLessThan2Pixels)
| | | (IfIntakeButtonPressed)
| | |[SpinIntakeMotor]
| | [StopIntakeMotor]
| =2
| | ->
| | | (Has1or2Pixels)
| | | (IfExtendSlideButtonPressed)
| | | [ExtendSlides]
| | | =2
| | | | ->
| | | | | (IfLeftReleasePixelButtonPressed)
| | | | | [ReleaseLeftPixel]
| | | | ->
| | | | | (IfRightReleasePixelButtonPressed)
| | | | | [ReleaseRightPixel]


| | ?
| | | ->

| | | | (AreSlidesNotExtended)
| | | | ->
| | | | | (IsControllerDriving)
| | | | | [Drive]
| | | (IsControllerDriving)
| | | (AreSlidesExtended)
| | | [SlowDrive]




 */
public class PushbotTeleop {
    public static Node root() {
        return new Parallel(5,
                new UpdateIntake(),
                new ResetGyro(),
                new DriveFieldRelative(),
                new UpdateClimber()

        );
    }


}
