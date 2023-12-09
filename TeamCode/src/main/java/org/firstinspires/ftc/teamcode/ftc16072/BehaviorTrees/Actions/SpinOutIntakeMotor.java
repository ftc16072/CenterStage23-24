package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class SpinOutIntakeMotor extends Node {

    @Override
    public State tick(QQOpMode opmode) {
        opmode.robot.intake.eject();
        return State.SUCCESS;
    }
}
