package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.TeleOp;

public class IsControllerDriving extends Node {
    TeleOp teleOp;
    @Override
    public State tick(QQOpMode opmode) {
        if (teleOp.gamepad1.left_stick_x>0.1){
            return State.SUCCESS;
        }
        if (teleOp.gamepad1.left_stick_y>0.1){
            return State.SUCCESS;
        }
        if (teleOp.gamepad1.right_stick_x>0.1){
            return State.SUCCESS;
        }
        return  State.FAILURE;
    }
}
