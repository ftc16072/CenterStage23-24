package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;
import org.firstinspires.ftc.teamcode.ftc16072.Util.Alliance;
import org.firstinspires.ftc.teamcode.ftc16072.Util.StartPosition;

public class isAllianceBlueClose extends Node {
    public State tick(QQOpMode opmode) {
        Alliance alliance = opmode.board.get(Alliance.class, "Alliance");
        StartPosition startPosition = opmode.board.get(StartPosition.class,"StartPosition");

        if (alliance == Alliance.BLUE || startPosition == StartPosition.CLOSE ){
            return State.SUCCESS;
        }
        return State.FAILURE;
    }
}