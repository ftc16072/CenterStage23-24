package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class IfEjectButtonPressed extends Node {
    @Override
    public State tick(QQOpMode opmode) {
        if (opmode.gamepad1.x){
            return State.SUCCESS;
        }
        return State.FAILURE;
    }
}
