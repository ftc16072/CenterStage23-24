package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.BaseNodes;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.BaseNodes.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

//Not reverses a value
public class Not extends Node {
    Node child;

    public Not(Node a) {
        this.child = a;
    }

    @Override
    public State tick(QQOpMode opmode) {
        State state = child.tick(opmode);

        if (state == State.FAILURE) {
            return State.SUCCESS;
        } else if (state == State.SUCCESS) {
            return State.FAILURE;
        }

        return state;
    }
}
