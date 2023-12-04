package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trees;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.ExtendSlides;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.MakeNormalDrive;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.MakeSlowDrive;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.ReleaseLeftPixel;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.ReleaseRightPixel;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.SpinInIntakeMotor;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.SpinOutIntakeMotor;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.StopIntakeMotor;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.AreNotSlidesExtended;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.AreSlidesExtended;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.Has1or2Pixels;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.HasLessThan2Pixels;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.HasMoreThan2Pixels;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.IfExtendSlideButtonPressed;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.IfIntakeButtonPressed;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.IfLeftReleasePixelButtonPressed;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.IfRightReleasePixelButtonPressed;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.IsControllerDriving;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.IsEndgame;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.IsLastThreeSeconds;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Failover;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Parallel;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Sequence;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.TeleOp;

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
        return new Parallel(3,
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

                new Failover(
                        new Sequence(
                                new HasLessThan2Pixels(),
                                new IfIntakeButtonPressed(),
                                new SpinInIntakeMotor()
                        ),
                        new StopIntakeMotor()
                ),
                new Sequence(
                        new HasMoreThan2Pixels(),
                        new SpinOutIntakeMotor()

                ),



                new Parallel(2,
                        new Sequence(
                                new Has1or2Pixels(),
                                new IfExtendSlideButtonPressed(),
                                new ExtendSlides(),
                                new Parallel(2,
                                        new Sequence(
                                                new IfLeftReleasePixelButtonPressed(),
                                                new ReleaseLeftPixel()
                                        ),
                                        new Sequence(
                                                new IfRightReleasePixelButtonPressed(),
                                                new ReleaseRightPixel()
                                        )
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
                                        new MakeNormalDrive()
                                )
                        )

                )
        );
    }


}
