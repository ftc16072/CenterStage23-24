package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Conditions;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class EnoughTimeForCycle extends Node{
        public static final int AUTO_TIME = //;

        @Override
        public State tick(QQOpMode opmode) {
            if(opmode.time > CYCLETIME){
                return State.SUCCESS;
            }
            return State.FAILURE;
        }
    }

/* need to change