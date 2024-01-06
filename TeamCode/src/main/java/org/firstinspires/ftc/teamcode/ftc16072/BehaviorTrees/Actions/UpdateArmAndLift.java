package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.Lift;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;
import org.firstinspires.ftc.teamcode.ftc16072.Util.ArmControl;

public class UpdateArmAndLift extends Node {
    ArmControl armControl;
    Lift lift;
    @Override
    public State tick(QQOpMode opmode) {
        armControl.updateArm();
        lift.update(opmode.telemetry);

        return State.RUNNING;

    }
}
