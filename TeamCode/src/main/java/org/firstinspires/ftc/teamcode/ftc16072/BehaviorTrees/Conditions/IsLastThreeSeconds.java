package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.BaseNodes.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class IsLastThreeSeconds extends Node {

    public static final int LAST_THREE_SECONDS = 117;

    @Override
    public State tick(QQOpMode opmode) {
        if(opmode.time > LAST_THREE_SECONDS){
            return State.SUCCESS;
        }
        return State.FAILURE;
    }
}
