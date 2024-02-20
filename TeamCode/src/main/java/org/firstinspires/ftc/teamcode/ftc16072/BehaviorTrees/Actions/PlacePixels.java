package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.BaseNodes.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class PlacePixels extends Node {
    @Override
    public State tick(QQOpMode opmode) {
        //TODO: change later so we can release pixels individually
        if(opmode.gamepad1.dpad_right){
            opmode.robot.placement.leftServoEject();
            opmode.robot.placement.rightServoEject();

        } else {
            opmode.robot.placement.leftServoGrab();
            opmode.robot.placement.rightServoGrab();
        }
        return State.RUNNING;
    }
}
