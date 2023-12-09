package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.AutoBase;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class IsClose extends Node {
    AutoBase autoBase;
    @Override
    public State tick(QQOpMode opmode) {
        if (autoBase.getIsCloseSide()){
            return State.SUCCESS;
        } else {
            return State.FAILURE;
        }

    }
}
