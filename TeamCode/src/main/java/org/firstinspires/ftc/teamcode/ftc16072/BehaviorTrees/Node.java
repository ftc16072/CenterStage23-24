package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees;

import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

abstract public class Node {
    /**
     * 3 states of all nodes
     */
    public enum State {
        SUCCESS,
        FAILURE,
        RUNNING
    }

    /**
     * each tick will
     *
     * @return state of node
     */
    public abstract State tick(QQOpMode opmode);


}


