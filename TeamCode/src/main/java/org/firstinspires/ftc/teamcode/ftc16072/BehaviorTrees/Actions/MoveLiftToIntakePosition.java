package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class MoveLiftToIntakePosition extends Node {
    @Override
    public State tick(QQOpMode opmode) {
        opmode.robot.lift.goToIntake();
        return State.SUCCESS;
    }
}
