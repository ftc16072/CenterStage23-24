package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class IfIntakeButtonPressed extends Node {
    public static final double TRIGGER_THRESHOLD = 0.1;

    @Override
    public State tick(QQOpMode opmode) {
        if (opmode.gamepad1.right_trigger> TRIGGER_THRESHOLD){
            return State.SUCCESS;
        }
        return  State.FAILURE;
    }
}
