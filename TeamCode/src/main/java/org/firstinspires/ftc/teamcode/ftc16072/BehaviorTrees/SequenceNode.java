package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees;

import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

import java.util.List;

public class SequenceNode extends Node {
    List<Node> children;

    public SequenceNode(List<Node> children) {
        this.children = children;

    }

    @Override
    public State tick(QQOpMode opmode) {
        for (Node child : children) {
            State state = child.tick(opmode);
            if (state == State.FAILURE) {
                return State.FAILURE;
            } else if (state == State.RUNNING) {
                return State.RUNNING;

            }
        }
        return State.SUCCESS;
    }
}
