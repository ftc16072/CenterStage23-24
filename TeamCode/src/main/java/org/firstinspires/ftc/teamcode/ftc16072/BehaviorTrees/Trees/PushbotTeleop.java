package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trees;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.AddTelemetry;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.ClampOnPixel;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.DriveFieldRelative;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.MakeFastDrive;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.MakeNormalDrive;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.MakeSlowDrive;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.MoveArmAndLift;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.MoveLiftToIntakePosition;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.MoveLiftToPixelGrabPosition;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.PlacePixels;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.PlacePixels2;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.ResetGyro;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.SetLiftPosition;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.SpinInIntakeMotor;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.SpinOutIntakeMotor;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.StopIntakeMotor;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.UpdateArmAndLift;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.UpdateClimber;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.AreNotSlidesExtended;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.AreSlidesExtended;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.Has1Pixel;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.Has1or2Pixels;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.Has2Pixels;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.HasLessThan2Pixels;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.IfEjectButtonPressed;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.IfIntakeButtonPressed;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.IfLeftTriggerPressed;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.IfLiftAtBottom;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.IfLiftToPixelGrabPosButtonPressed;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.IsControllerDriving;
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
public class PushbotTeleop {
    public static Node root(){
        return new Parallel(5,
                new Failover(
                        new Sequence(
                                new IfIntakeButtonPressed(),
                                new SpinInIntakeMotor()
                        ),
                        new Sequence(
                                new IfEjectButtonPressed(), // might want to consider removing this and automatically ejecting
                                new SpinOutIntakeMotor()

                        ),
                        new StopIntakeMotor()

                ),
                new ResetGyro(),

                new DriveFieldRelative(),

                new UpdateClimber()

        );
    }


}
