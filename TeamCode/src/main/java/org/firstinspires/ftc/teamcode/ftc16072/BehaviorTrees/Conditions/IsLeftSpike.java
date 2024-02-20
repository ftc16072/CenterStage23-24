package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.BaseNodes.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;
import org.firstinspires.ftc.teamcode.ftc16072.Util.TeamPropLocation;

public class IsLeftSpike extends Node {
    @Override
    public State tick(QQOpMode opmode) {
        TeamPropLocation location = opmode.board.get(TeamPropLocation.class, "proplocation");
        if (location == TeamPropLocation.LEFT_SPIKE){
            return State.SUCCESS;
        }
        return State.FAILURE;
    }
}
