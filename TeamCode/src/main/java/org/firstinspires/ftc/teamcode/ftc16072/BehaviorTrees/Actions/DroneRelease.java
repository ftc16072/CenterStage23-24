package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class DroneRelease extends Node {

    @Override
    public State tick(QQOpMode opmode) {
        opmode.robot.drone.releaseDrone();
        return State.SUCCESS;
    }
}
