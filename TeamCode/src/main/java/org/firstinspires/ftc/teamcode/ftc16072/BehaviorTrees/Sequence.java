package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees;

import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

import java.util.Arrays;
import java.util.List;

public class Sequence extends Node {
    List<Node> children;

    public Sequence(Node... a) {
        this.children = Arrays.asList(a);
    }

    @Override
    public State tick(QQOpMode opmode) {
        opmode.debug.startParent(this);

        for (Node child : children) {
            opmode.debug.addNode(child);
            State state = child.tick(opmode);
            opmode.debug.updateNode(child, state);

            if (state == State.FAILURE) {
                return State.FAILURE;
            } else if (state == State.RUNNING) {
                return State.RUNNING;
            }
        }
        return State.SUCCESS;
    }
}
