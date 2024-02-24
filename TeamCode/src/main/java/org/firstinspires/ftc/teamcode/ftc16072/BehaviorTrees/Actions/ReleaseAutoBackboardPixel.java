package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class ReleaseAutoBackboardPixel extends Node {
    @Override
    public State tick(QQOpMode opmode) {
        opmode.robot.placement.leftServoEject();
        opmode.robot.placement.rightServoEject();
        return State.SUCCESS;
    }
}
