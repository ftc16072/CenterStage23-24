package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees;

import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

import java.util.Arrays;
import java.util.List;

public class Parallel extends Node {
    List<Node> children;
    int requiredSuccesses;

    public Parallel(int requiredSuccesses, Node ... a) {
        this.children = Arrays.asList(a);
        this.requiredSuccesses = requiredSuccesses;
    }

    @Override
    public State tick(QQOpMode opmode) {
        int numSuccessful = 0;
        boolean anyRunning = false;
        opmode.debug.startParent(this);
        for (Node child : children) {
            opmode.debug.addNode(child);
            State state = child.tick(opmode);
            opmode.debug.updateNode(child, state);

            if (state == State.SUCCESS) {
                numSuccessful += 1;
                if (numSuccessful >= requiredSuccesses){
                    return State.SUCCESS;
                }
            } else if (state == State.RUNNING) {
                anyRunning = true;
            }
        }
        if (anyRunning){
            return State.RUNNING;
        }
        return State.FAILURE;
    }
}
