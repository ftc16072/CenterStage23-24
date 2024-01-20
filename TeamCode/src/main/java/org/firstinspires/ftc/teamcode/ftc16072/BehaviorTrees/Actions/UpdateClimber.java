package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;

public class UpdateClimber extends Node {

    @Override
    public State tick(QQOpMode opmode) {
        if(opmode.gamepad2.dpad_up){
            opmode.robot.climber.up();
        }
        else if(opmode.gamepad2.dpad_down){
            opmode.robot.climber.down();
        }
        else{
            opmode.robot.climber.stop();
        }
        return State.RUNNING;
    }
}
