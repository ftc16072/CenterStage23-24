package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class DriveFieldRelative extends Node {
    private double squareWithSign(double number) {
        return number * number * Math.signum(number);
    }

    @Override
    public State tick(QQOpMode opmode) {
        opmode.robot.nav.fieldRelative(squareWithSign(-opmode.gamepad1.left_stick_y),
                squareWithSign(opmode.gamepad1.left_stick_x),
                squareWithSign(opmode.gamepad1.right_stick_x));
        return State.RUNNING;
    }
}
