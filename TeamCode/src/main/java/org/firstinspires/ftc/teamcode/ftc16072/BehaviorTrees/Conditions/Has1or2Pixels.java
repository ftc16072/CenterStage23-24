package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class Has1or2Pixels extends Node {
    @Override
    public State tick(QQOpMode opmode) {

        opmode.telemetry.addData("num pixels", opmode.robot.holdingCell.getNumPixels());
        if (opmode.robot.holdingCell.getNumPixels() >= 1) {
            return State.SUCCESS;
        }
        return State.FAILURE;


    }
}
