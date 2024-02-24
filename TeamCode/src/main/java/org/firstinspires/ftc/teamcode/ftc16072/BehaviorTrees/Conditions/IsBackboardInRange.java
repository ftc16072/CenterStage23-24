package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class IsBackboardInRange extends Node {
    public double BACKBOARD_RANGE_CM = 15;

    @Override
    public State tick(QQOpMode opmode) {
        if (opmode.robot.backDistanceSensor.distanceToBackboard() < BACKBOARD_RANGE_CM) {
            return State.SUCCESS;
        }
        return State.FAILURE;

    }
}
