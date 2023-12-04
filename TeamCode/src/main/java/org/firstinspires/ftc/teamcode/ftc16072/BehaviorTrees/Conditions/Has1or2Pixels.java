package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;
import org.firstinspires.ftc.teamcode.ftc16072.Robot;

public class Has1or2Pixels extends Node {
    Robot robot;
    @Override
    public State tick(QQOpMode opmode) {

        if (robot.holdingCell.getNumPixels()>0){
            return State.SUCCESS;
        }
        return  State.FAILURE;


    }
}
