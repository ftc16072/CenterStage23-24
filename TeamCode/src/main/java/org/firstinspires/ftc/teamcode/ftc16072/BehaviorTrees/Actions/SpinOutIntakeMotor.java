package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;
import org.firstinspires.ftc.teamcode.ftc16072.Robot;

public class SpinOutIntakeMotor extends Node {
    Robot robot;
    @Override
    public State tick(QQOpMode opmode) {
        robot.intake.eject();
        return State.SUCCESS;
    }
}
