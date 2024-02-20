package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class IfExtendSlideButtonPressed extends Node {

    @Override
    public State tick(QQOpMode opmode) {
        if(opmode.gamepad1.right_bumper){
            return State.SUCCESS;
        }
        if(opmode.gamepad1.left_bumper){
            return State.SUCCESS;
        }
        //if(opmode.gamepad1.y){
          //  return State.SUCCESS;
        //}
        if(opmode.gamepad1.b){
            return State.SUCCESS;
        }
        return  State.FAILURE;
    }
}
