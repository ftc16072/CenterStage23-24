package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.Placement;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class ReleaseRightPixel extends Node {
    Placement placement;
    @Override
    public State tick(QQOpMode opmode) {
        placement.rightServoEject();
        return State.SUCCESS;
    }
}
