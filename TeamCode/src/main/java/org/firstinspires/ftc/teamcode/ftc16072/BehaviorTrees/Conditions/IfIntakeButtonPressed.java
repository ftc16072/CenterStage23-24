package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.TeleOp;

public class IfIntakeButtonPressed extends Node {
    TeleOp teleOp;
    @Override
    public State tick(QQOpMode opmode) {
        if (teleOp.gamepad1.right_trigger>0.1){
            return State.SUCCESS;
        }
        return  State.FAILURE;
    }
}
