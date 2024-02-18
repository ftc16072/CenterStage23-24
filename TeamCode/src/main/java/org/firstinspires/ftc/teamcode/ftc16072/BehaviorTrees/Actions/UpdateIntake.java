package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class UpdateIntake extends Node {
    public static final double TRIGGER_THRESHOLD = 0.1;

    @Override
    public State tick(QQOpMode opmode) {
        if (opmode.gamepad1.right_trigger > TRIGGER_THRESHOLD){
            opmode.robot.intake.intake(opmode.gamepad1.right_trigger);
        }
        else if (opmode.gamepad1.x){
            opmode.robot.intake.eject();
        }
        else{
            opmode.robot.intake.stop();
        }
        return State.RUNNING;
    }
}
