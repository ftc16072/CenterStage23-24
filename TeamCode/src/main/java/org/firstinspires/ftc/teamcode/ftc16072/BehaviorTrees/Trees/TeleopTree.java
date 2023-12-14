package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trees;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.DriveFieldRelative;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.ExtendSlides;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.MakeFastDrive;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.MakeNormalDrive;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.MakeSlowDrive;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.MoveArmAndLift;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.ReleaseLeftPixel;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.ReleaseRightPixel;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.SetLiftPosition;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.SpinInIntakeMotor;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.SpinOutIntakeMotor;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.StopIntakeMotor;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.AreNotSlidesExtended;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.AreSlidesExtended;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.Has1or2Pixels;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.HasLessThan2Pixels;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.HasMoreThan2Pixels;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.IfEjectButtonPressed;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.IfExtendSlideButtonPressed;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.IfIntakeButtonPressed;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.IfLeftReleasePixelButtonPressed;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.IfLeftTriggerPressed;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.IfRightReleasePixelButtonPressed;
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
    public static Node placePixels(){
        return  new Parallel(2,
                new Sequence(
                        new IfLeftReleasePixelButtonPressed(),
                        new ReleaseLeftPixel()
                ),
                new Sequence(
                        new IfRightReleasePixelButtonPressed(),
                        new ReleaseRightPixel()
                )
        );
    }

    public static Node root(){
        return new Parallel(4,
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

                new Failover(
                        new Sequence(
                                //new HasLessThan2Pixels(),
                                new IfIntakeButtonPressed(),
                                new SpinInIntakeMotor()
                        ),
                        new Sequence(
                                //new HasMoreThan2Pixels(), // having more than 2 pixels is impossible
                                new IfEjectButtonPressed(),
                                new SpinOutIntakeMotor() // X not using eject
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
                                //new Has1or2Pixels(),
                                new Failover(
                                        new Sequence(
                                                new MoveArmAndLift()

                                        )


                                ),
                                placePixels()

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
