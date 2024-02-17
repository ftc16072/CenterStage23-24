package org.firstinspires.ftc.teamcode.ftc16072.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trees.SpikeAutoTree;
import org.firstinspires.ftc.teamcode.ftc16072.Util.Alliance;

abstract public class SpikeAutoBase extends VisionBase{
    Node root = SpikeAutoTree.root();

    boolean done;
    @Override
    public void init(){
        super.init();
        board.add("proploocation", robot.cameraBack.getTeamPropPosition());
        robot.makeDriveOnly();

        telemetry.addData("prop Location", robot.cameraBack.getTeamPropPosition());
    }
    @Override
    public void loop() {
        if(!done){
            Node.State state = root.tick(this);
            if(state == Node.State.SUCCESS){
                done = true;
            }
        }
    }
}
