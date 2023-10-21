package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees;

import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

import java.util.Arrays;
import java.util.List;

public class Failover extends Node {
    List<Node> children;

    public Failover(Node ... a) {
        this.children = Arrays.asList(a);
    }

    @Override
    public State tick(QQOpMode opmode) {
        for (Node child : children) {
            State state = child.tick(opmode);
            if (state == State.SUCCESS) {
                return State.SUCCESS;
            } else if (state == State.RUNNING) {
                return State.RUNNING;
            }
        }
        return State.FAILURE;
    }
}
