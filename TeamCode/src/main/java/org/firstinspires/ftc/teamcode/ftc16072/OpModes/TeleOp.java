package org.firstinspires.ftc.teamcode.ftc16072.OpModes;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trees.TeleopTree;
import org.firstinspires.ftc.teamcode.ftc16072.Robot;

public class TeleOp extends  QQOpMode{
    Robot robot;
    TeleopTree tree;
    @Override
    public void loop() {
        driverLoop(gamepad1);
        manipulatorLoop(gamepad2);

    }

    public void driverLoop(Gamepad gamepad1){
        if (gamepad1.right_bumper){
            //manual slides up
        } else if (gamepad1.left_bumper){
            // manual slides down
        }

        if (gamepad1.right_trigger>0.1){
            //intake
        } else (gamepad1.left_trigger>0.1){
            // eject
        }
        if (gamepad1.dpad_right){
            // move climber down
        } else if (gamepad1.dpad_left){
            //move climber up
        }
        if (gamepad1.dpad_down){
            //move slides down 1 pixel
        } else if (gamepad1.dpad_up){
            //move slides up 1 pixel
        }
        if (gamepad1.a){
            //release pixel from grabber
        }
        if (gamepad1.y){
            //reset slides
        } else if (gamepad1.b){
            // go to slides
        }


    }
    public void manipulatorLoop(Gamepad gamepad2){


    }
}
