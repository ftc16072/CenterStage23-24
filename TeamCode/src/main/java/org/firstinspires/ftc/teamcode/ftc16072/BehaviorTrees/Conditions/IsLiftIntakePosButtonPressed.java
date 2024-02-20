package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class IsLiftIntakePosButtonPressed extends Node {
    @Override
    public State tick(QQOpMode opmode) {
     if(gamepad1.x){
         return State.SUCCESS;
     }else{
         return State.FAILURE;
     }
    }
}
