package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trees;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.DriveFieldRelative;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.DroneRelease;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.MakeFastDrive;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.MakeNormalDrive;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.MoveArmAndLift;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.PlacePixels;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.ResetGyro;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.RumbleGamepad;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.UpdateArmAndLift;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.UpdateClimber;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.UpdateIntake;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.AreSlidesExtended;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.Has1or2Pixels;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.IfLeftTriggerPressed;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.IfLiftAtBottom;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.IsBackboardInRange;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.IsControllerDriving;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.ifDroneReleaseButtonPressed;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.BaseNodes.Failover;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.BaseNodes.Node;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.BaseNodes.Not;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.BaseNodes.Parallel;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.BaseNodes.Sequence;

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
                new Sequence(
                        new ifDroneReleaseButtonPressed(),
                        new DroneRelease()


                ),
                new ResetGyro(),
                new UpdateClimber(),
                new DriveFieldRelative(),

                new UpdateArmAndLift(),
                //Distance Sensor Rumbles when
                new Sequence(
                        new IsBackboardInRange(),
                        new RumbleGamepad()
                ),
                /*
                new Failover(

                        new Sequence(
                            new HasLessThan2Pixels(),
                                new IfIntakeButtonPressed(),
                                new SpinInIntakeMotor(), // currently the lift moves to intake position when the intake is turned on
                                new MoveLiftToIntakePosition()  // might want to consider adding an additional conditional if this is consistently being mispressed
                        ),
                        new Sequence( // moving lift down to grab pixels when there is 2 pixels
                                new Has2Pixels(), // having more than 2 pixels is impossible
                                //new MoveLiftToPixelGrabPosition(),


                                new IfEjectButtonPressed() // might want to consider removing this and automatically ejecting
                                //new SpinOutIntakeMotor() // X not using eject


                        ),
                        new Sequence( // moving lift down to grab pixels when there is only 1 pixel
                                new Has1Pixel(),

                                new IfLiftToPixelGrabPosButtonPressed(),
                                new MoveLiftToPixelGrabPosition(),
                                new ClampOnPixel(),
                                new IfEjectButtonPressed()
                                //new SpinOutIntakeMotor() // X not using eject

                        ),
                        new StopIntakeMotor()

                 */
                new UpdateIntake(),

                /*new Sequence(
                                new SetLiftPosition()
                ),*/
                new Parallel(2,
                        new Failover(
                                new Sequence(
                                        new IfLiftAtBottom(),
                                        new Has1or2Pixels(),
                                        new Parallel(2,

                                                new MoveArmAndLift(),
                                                new PlacePixels()
                                        )




                                ),
                                new Failover(
                                        new IfLiftAtBottom(),
                                        new Parallel(2,
                                                new MoveArmAndLift(),
                                                new PlacePixels()
                                        )


                                )




                        ),
                        //new Failover(
                        //        new AreSlidesExtended(),
                        //        new IsControllerDriving(),
                        //        new MakeSlowDrive()
                        //),
                        new Sequence(
                                new Not(
                                      new AreSlidesExtended()
                                        ),
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
