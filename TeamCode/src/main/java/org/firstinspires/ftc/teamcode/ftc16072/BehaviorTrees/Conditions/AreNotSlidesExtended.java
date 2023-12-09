package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.Lift;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class AreNotSlidesExtended extends Node {
    Lift lift;
    @Override
    public State tick(QQOpMode opmode) {
        if (lift.areSlidesExtendedPastBoundary()){
            return  State.FAILURE;
        }
        return State.SUCCESS;
    }
}