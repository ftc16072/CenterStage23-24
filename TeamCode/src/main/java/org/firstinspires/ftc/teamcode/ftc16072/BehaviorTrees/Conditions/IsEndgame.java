package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class IsEndgame extends Node {

    public static final int ENDGAME_TIME = 90;

    @Override
    public State tick(QQOpMode opmode) {
        if(opmode.time > ENDGAME_TIME){
            return State.SUCCESS;
        }
        return State.FAILURE;
    }
}
