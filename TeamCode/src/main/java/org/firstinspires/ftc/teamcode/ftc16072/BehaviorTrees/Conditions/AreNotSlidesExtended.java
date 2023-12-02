package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.Lift;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class AreNotSlidesExtended extends Node {
    public static final int ARE_SLIDES_EXTENDED_BOUNDARY = 100; //TODO tune value
    Lift lift;
    @Override
    public State tick(QQOpMode opmode) {
        if (lift.currentPosition()> ARE_SLIDES_EXTENDED_BOUNDARY){
            return  State.FAILURE;
        }
        return State.SUCCESS;
    }
}
