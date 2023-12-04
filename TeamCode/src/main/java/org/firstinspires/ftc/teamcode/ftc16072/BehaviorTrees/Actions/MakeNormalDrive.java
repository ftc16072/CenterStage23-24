package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.MecanumDrive;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class MakeNormalDrive extends Node {
    MecanumDrive mecanumDrive;
    @Override
    public State tick(QQOpMode opmode) {
        mecanumDrive.doSlowDrive = false;
        return  State.SUCCESS;
    }
}
