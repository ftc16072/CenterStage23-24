package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class SpikeLocationTelemetry extends Node {
    @Override
    public State tick(QQOpMode opmode) {
        opmode.telemetry.addData("Prop Location: ", opmode.robot.cameraBack.getTeamPropPosition());
        return State.SUCCESS;
    }
}
