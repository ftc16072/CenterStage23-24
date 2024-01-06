package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;
import org.firstinspires.ftc.teamcode.ftc16072.Util.ArmControl;

public class UpdateArm extends Node {
    ArmControl armControl;
    @Override
    public State tick(QQOpMode opmode) {
        armControl.updateArm();
        return State.RUNNING;

    }
}
