package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trees;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.DriveFieldRelative;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.MakeFastDrive;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.MakeNormalDrive;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.MakeSlowDrive;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.MoveArmAndLift;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.ResetGyro;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.UpdateArmAndLift;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.UpdateClimber;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.UpdateGrabber;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.UpdateIntake;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.AreNotSlidesExtended;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.AreSlidesExtended;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.IfLeftTriggerPressed;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Failover;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Parallel;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Sequence;

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
public class TeleopTree {
    public static Node root(){
        return new Parallel(6,
                new DriveFieldRelative(),
                new MoveArmAndLift(),
                new UpdateArmAndLift(),
                new UpdateClimber(),
                new ResetGyro(),
                new UpdateIntake(),
                new UpdateGrabber(),
                new Sequence(
                    new Failover(
                            new AreNotSlidesExtended(),
                            new MakeSlowDrive()
                    ),
                    new Failover(
                            new AreSlidesExtended(),
                            new Sequence(
                                    new IfLeftTriggerPressed(),
                                    new MakeFastDrive()
                            ),
                            new MakeNormalDrive()
                    )
                )
        );
    }
}
