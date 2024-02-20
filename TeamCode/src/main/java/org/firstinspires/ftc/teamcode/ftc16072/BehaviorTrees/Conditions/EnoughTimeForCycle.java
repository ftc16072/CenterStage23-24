package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.BaseNodes.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class EnoughTimeForCycle extends Node{
        public static final int CYCLE_TIME = 0; //TODO: THIS IS WRONG!!!!

        @Override
        public State tick(QQOpMode opmode) {
            if(opmode.time > CYCLE_TIME){
                return State.SUCCESS;
            }
            return State.FAILURE;
        }
    }

// need to change