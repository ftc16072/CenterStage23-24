package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class IfLiftAtBottom extends Node {
    @Override
    public State tick(QQOpMode opmode) {
        if(opmode.robot.holdingCell.isLimitSwitchDetected()){
            return State.SUCCESS;


        }
        return State.FAILURE;
    }
}
