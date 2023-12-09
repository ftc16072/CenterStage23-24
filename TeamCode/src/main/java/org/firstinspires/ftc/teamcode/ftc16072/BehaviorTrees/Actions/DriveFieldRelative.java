package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.TeleOp;
import org.firstinspires.ftc.teamcode.ftc16072.Robot;

public class DriveFieldRelative extends Node {
    Robot robot;
    TeleOp teleOp;
    @Override
    public State tick(QQOpMode opmode) {
        robot.nav.fieldRelative(-teleOp.gamepad1.left_stick_y,
                teleOp.gamepad1.left_stick_x,
                teleOp.gamepad1.right_stick_x);
        return State.SUCCESS;
    }
}
