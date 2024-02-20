package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.BaseNodes.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class IfLiftAtBottom extends Node {
    @Override
    public State tick(QQOpMode opmode) {
        opmode.telemetry.addData("limit switch", opmode.robot.holdingCell.isLimitSwitchDetected());
        if(opmode.robot.holdingCell.isLimitSwitchDetected()){
            return State.SUCCESS;


        }
        return State.FAILURE;
    }
}
