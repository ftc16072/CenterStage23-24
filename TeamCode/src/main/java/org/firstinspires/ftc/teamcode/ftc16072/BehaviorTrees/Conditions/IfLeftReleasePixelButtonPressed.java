package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.TeleOp;

public class IfLeftReleasePixelButtonPressed extends Node {
    TeleOp teleOp;
    @Override
    public State tick(QQOpMode opmode) {
        if(teleOp.gamepad1.x){
            return State.SUCCESS;
        }
        return  State.FAILURE;
    }
}
