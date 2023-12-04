package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;
import org.firstinspires.ftc.teamcode.ftc16072.Robot;

public class SpinInIntakeMotor extends Node {
    Robot robot;
    @Override
    public State tick(QQOpMode opmode) {
        robot.intake.intake();
        return State.SUCCESS;
    }
}
