package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class MoveLiftToPixelGrabPosition extends Node {
    @Override
    public State tick(QQOpMode opmode) {
        opmode.liftControl.goToPixelGrab();
        return State.SUCCESS;
    }
}
