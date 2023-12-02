package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trees;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.IsEndgame;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions.IsLastThreeSeconds;
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
                                new SpinIntakeMotor()
                        ),
                        new StopIntakeMotor()
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
                        new Sequence(
                                new AreSlidesExtended(),
                                new IsControllerDriving(),
                                new slowDrive(),
                                    new Sequence(
                                        new AreSlidesNotExtended(),
                                        new Sequence(
                                                new IsControllerDriving(),
                                                new NormalSpeedDrive()
                                        )
                                    )


                        )

                )
        );
    }


}
