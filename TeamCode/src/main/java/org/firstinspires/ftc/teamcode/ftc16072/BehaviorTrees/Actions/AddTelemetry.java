package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.BaseNodes.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class AddTelemetry extends Node {
    @Override
    public State tick(QQOpMode opmode) {
        opmode.telemetry.addData("behavior tree is here: ", 11);
        return State.SUCCESS;
    }
}
