package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.TeleOp;

public class IfExtendSlideButtonPressed extends Node {
    TeleOp teleOp;
    @Override
    public State tick(QQOpMode opmode) {
        if(teleOp.gamepad1.right_bumper){
            return State.SUCCESS;
        }
        if(teleOp.gamepad1.left_bumper){
            return State.SUCCESS;
        }
        if(teleOp.gamepad1.y){
            return State.SUCCESS;
        }
        if(teleOp.gamepad1.b){
            return State.SUCCESS;
        }
        return  State.FAILURE;
    }
}
