package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.BaseNodes.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;
import org.firstinspires.ftc.teamcode.ftc16072.Util.ArmControl;

public class UpdateArmAndLift extends Node {
    ArmControl armControl = new ArmControl();
    @Override
    public State tick(QQOpMode opmode) {
        armControl.updateArm(opmode.robot);

        opmode.robot.lift.update(opmode.telemetry);

        return State.RUNNING;

    }
}
