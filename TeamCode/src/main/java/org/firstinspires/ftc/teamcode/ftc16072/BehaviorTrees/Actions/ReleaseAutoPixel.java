package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.Trajectories.SetLeftSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.Trajectories.SetMiddleSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions.Trajectories.SetRightSpikeTrajectory;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.PixelServo;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class ReleaseAutoPixel extends Node {


    @Override
    public State tick(QQOpMode opmode) {
        opmode.robot.pixelServo.releasePixel();
        return State.SUCCESS;
    }


}
