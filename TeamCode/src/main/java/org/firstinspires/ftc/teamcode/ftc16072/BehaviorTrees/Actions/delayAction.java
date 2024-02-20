package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.BaseNodes.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class delayAction extends Node {
    double delayTill;
    double delayTime=2;
    @Override
    public State tick(QQOpMode opmode) {
        if(delayTill==0){
            delayTill = opmode.time + delayTime;
        }
        if(opmode.time>= delayTill){
            return State.SUCCESS;
        } else{
            return State.RUNNING;
        }

    }
}
