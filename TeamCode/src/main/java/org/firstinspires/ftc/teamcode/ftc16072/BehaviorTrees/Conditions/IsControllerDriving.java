package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class IsControllerDriving extends Node {
    public static final double TRIGGER_CONSTANT = 0.1;

    @Override
    public State tick(QQOpMode opmode) {
        if (Math.abs(opmode.gamepad1.left_stick_x) > TRIGGER_CONSTANT) {
            return State.SUCCESS;
        }
        if (Math.abs(opmode.gamepad1.left_stick_y) > TRIGGER_CONSTANT) {
            return State.SUCCESS;
        }
        if (Math.abs(opmode.gamepad1.right_stick_x) > TRIGGER_CONSTANT) {
            return State.SUCCESS;
        }
        return State.FAILURE;
    }
}
