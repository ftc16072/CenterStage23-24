package org.firstinspires.ftc.teamcode.ftc16072.OpModes;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trees.SpikeAutoTree;

abstract public class SpikeAutoBase extends VisionBase {
    Node root = SpikeAutoTree.root();

    boolean done;

    @Override
    public void init() {
        super.init();
        robot.makeDriveOnly();
    }

    @Override
    public void init_loop() {
        telemetry.addData("PropLocation: ", robot.cameraBack.getTeamPropPosition());
    }

    @Override
    public void start() {
        board.add("proplocation", robot.cameraBack.getTeamPropPosition());
    }

    @Override
    public void loop() {
        if (!done) {
            Node.State state = root.tick(this);
            if (state == Node.State.SUCCESS) {
                done = true;
            }
        }
    }
}
