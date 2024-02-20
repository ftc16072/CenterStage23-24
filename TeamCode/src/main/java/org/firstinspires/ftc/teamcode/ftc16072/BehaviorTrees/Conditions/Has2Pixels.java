package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.BaseNodes.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class Has2Pixels extends Node {

    @Override
    public State tick(QQOpMode opmode) {
        if (opmode.robot.holdingCell.getNumPixels()==2){
            return State.SUCCESS;
        }
        return  State.FAILURE;

    }



}

