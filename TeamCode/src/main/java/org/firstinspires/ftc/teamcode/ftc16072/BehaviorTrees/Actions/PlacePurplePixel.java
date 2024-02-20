package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.BaseNodes.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class PlacePurplePixel extends Node {
    @Override
    public State tick(QQOpMode opmode) {
        opmode.robot.pixelServo.releasePixel();
        return State.SUCCESS;
    }
}
