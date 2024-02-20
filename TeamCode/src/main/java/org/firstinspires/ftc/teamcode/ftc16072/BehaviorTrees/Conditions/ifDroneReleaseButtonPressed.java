package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.BaseNodes.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class ifDroneReleaseButtonPressed extends Node {
    @Override
    public State tick(QQOpMode opmode) {
        if (opmode.gamepad2.right_trigger>0.25){
            return State.SUCCESS;
        }

        return State.FAILURE;
    }
}
