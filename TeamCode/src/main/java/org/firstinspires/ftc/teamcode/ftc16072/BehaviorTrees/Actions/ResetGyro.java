package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class ResetGyro extends Node {

    @Override
    public State tick(QQOpMode opmode) {
        if (opmode.gamepad2.x) {
            opmode.robot.controlHub.resetHeading(-90, AngleUnit.DEGREES);
        } else if (opmode.gamepad2.y) {
            opmode.robot.controlHub.resetHeading(0, AngleUnit.DEGREES);
        } else if (opmode.gamepad2.b) {
            opmode.robot.controlHub.resetHeading(90, AngleUnit.DEGREES);
        } else if (opmode.gamepad2.a) {
            opmode.robot.controlHub.resetHeading(180, AngleUnit.DEGREES);
        }
        return State.RUNNING;
    }
}
