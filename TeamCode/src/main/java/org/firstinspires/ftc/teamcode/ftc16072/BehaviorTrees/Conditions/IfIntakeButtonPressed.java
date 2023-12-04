package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.TeleOp;

public class IfIntakeButtonPressed extends Node {
    public static final double TRIGGER_THRESHOLD = 0.1;
    TeleOp teleOp;
    @Override
    public State tick(QQOpMode opmode) {
        if (teleOp.gamepad1.right_trigger> TRIGGER_THRESHOLD){
            return State.SUCCESS;
        }
        return  State.FAILURE;
    }
}
