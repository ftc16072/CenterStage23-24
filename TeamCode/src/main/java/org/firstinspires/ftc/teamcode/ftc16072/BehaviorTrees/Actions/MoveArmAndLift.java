package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.Lift;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class MoveArmAndLift extends Node {
    @Override
    public State tick(QQOpMode opmode) {
        if (opmode.gamepad1.y) {
            opmode.liftControl.goToFloor();
        }
        else if (opmode.gamepad1.b){
            if (opmode.liftControl.atPosition(Lift.LiftPositions.LOW_POSITION)){
                opmode.robot.arm.goToPlacingPosition();
                new delayAction();
                opmode.liftControl.goToLow();
            } else if (opmode.liftControl.atPosition(Lift.LiftPositions.MIDDLE_POSITION)){
                opmode.robot.arm.goToPlacingPosition();
                new delayAction();
                opmode.liftControl.goToMiddle();
            } else if (opmode.liftControl.atPosition(Lift.LiftPositions.TOP_POSITION)){
                opmode.robot.arm.goToPlacingPosition();
                new delayAction();
                opmode.liftControl.goToTop();
            } else if (opmode.liftControl.atPosition(Lift.LiftPositions.FLOOR_POSITION)){
                opmode.robot.arm.goToIntakePosition();
                new delayAction();
                opmode.liftControl.goToFloor();
            }
        } else  if (opmode.gamepad1.dpad_down){
            opmode.liftControl.downOnePixel();
        } else if (opmode.gamepad1.dpad_up){
            opmode.liftControl.upOnePixel();
        } else if (opmode.gamepad1.right_bumper){
            opmode.liftControl.manualLiftUp();
        } else if (opmode.gamepad1.left_bumper){
            opmode.liftControl.manualLiftDown();

        }
        return State.RUNNING;
    }
}
