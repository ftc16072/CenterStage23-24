package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class DriveFieldRelative extends Node {

    @Override
    public State tick(QQOpMode opmode) {
        opmode.robot.nav.fieldRelative(-opmode.gamepad1.left_stick_y,
                opmode.gamepad1.left_stick_x,
                opmode.gamepad1.right_stick_x);
        return State.RUNNING;
    }
}
