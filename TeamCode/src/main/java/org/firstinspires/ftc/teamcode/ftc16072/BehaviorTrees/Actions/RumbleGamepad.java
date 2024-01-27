package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class RumbleGamepad extends Node {
    @Override
    public State tick(QQOpMode opmode) {
        opmode.gamepad1.rumbleBlips(2);
        return State.SUCCESS;
    }
}
