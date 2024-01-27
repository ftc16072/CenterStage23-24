package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trees;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.ClampOnPixel;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.DriveFieldRelative;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.MakeFastDrive;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.MakeNormalDrive;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.MakeSlowDrive;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.MoveArmAndLift;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.MoveLiftToPixelGrabPosition;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.PlacePixels;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.RumbleGamepad;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.SetLiftPosition;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.SpinInIntakeMotor;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.SpinOutIntakeMotor;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.StopIntakeMotor;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.UpdateArmAndLift;
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
public class TeleopTree {
    public static Node root(){
        return new Parallel(5,
                /*
                new Sequence(

                    new IsEndgame(),

                    new Parallel(2,
                            new Sequence(
                                    new Failover(
                                            new IsLastThreeSeconds(),
                                            new Sequence(
                                                new IsDroneLocation(),
                                                new IsDroneButtonPressed()
                                            )
                                    ),
                                    new HaveNotLaunchedDrone(),
                                    new LaunchDrone()
                            ),

                            new Sequence(
                                    new IsClimbLocation(),
                                    new IsClimbButtonPressed(),
                                    new Climb()
                            )
                    )
                ),

                 */
                new DriveFieldRelative(),
                new UpdateArmAndLift(),
                new Failover(
                        new Sequence(
                                new HasLessThan2Pixels(),
                                new IfIntakeButtonPressed(),
                                new SpinInIntakeMotor()
                        ),
                        new Sequence( // moving lift down to grab pixels when there is 2 pixels
                                new Has2Pixels(), // having more than 2 pixels is impossible
                                new IfEjectButtonPressed(),
                                new SpinOutIntakeMotor(), // X not using eject
                                new MoveLiftToPixelGrabPosition(),
                                new ClampOnPixel()

                        ),
                        new Sequence( // moving lift down to grab pixels when there is only 1 pixel
                                new Has1Pixel(),
                                new IfEjectButtonPressed(),
                                new SpinOutIntakeMotor(), // X not using eject
                                new IfLiftToPixelGrabPosButtonPressed(),
                                new MoveLiftToPixelGrabPosition(),
                                new ClampOnPixel() //TODO

                        ),
                        new StopIntakeMotor()
                ),
                new Failover(
                        new Sequence(
                                new SetLiftPosition()
                        )
                ),
                new Parallel(2,
                        new Sequence(
                                new Failover(
                                        new IfLiftAtBottom(),
                                        new Has1or2Pixels(),

                                        new Failover(
                                                new Sequence(
                                                        new MoveArmAndLift(),
                                                        new PlacePixels()
                                                )

                                        )

                                ),

                                new Sequence(
                                        new MoveArmAndLift(),
                                        new PlacePixels()
                                )




                        ),
                        new Failover(
                                new AreSlidesExtended(),
                                new IsControllerDriving(),
                                new MakeSlowDrive()
                        ),
                        new Sequence(
                                new AreNotSlidesExtended(),
                                new Sequence(
                                        new IsControllerDriving(),
                                        new Failover(
                                                new MakeNormalDrive(),
                                                new Sequence(
                                                        new IfLeftTriggerPressed(),
                                                        new MakeFastDrive()

                                                )


                                        )

                                )
                        )

                )
        );
    }


}
