package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.BaseNodes.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class AreNotSlidesExtended extends Node {

    @Override
    public State tick(QQOpMode opmode) {
        if (opmode.robot.lift.areSlidesExtendedPastBoundary()){
            return  State.FAILURE;
        }
        return State.SUCCESS;
    }
}
