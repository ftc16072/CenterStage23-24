package org.firstinspires.ftc.teamcode.ftc16072.OpModes;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trees.TeleopTree;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.Lift;
import org.firstinspires.ftc.teamcode.ftc16072.Robot;

public class TeleOp extends  QQOpMode{



    Robot robot;

    @Override
    public void loop() {
        new TeleopTree();
        driverLoop(gamepad1);
        manipulatorLoop(gamepad2);

    }

    public void driverLoop(Gamepad gamepad1){


        if (gamepad1.right_bumper){
            robot.lift.manualLiftUp();
        } else if (gamepad1.left_bumper){
            robot.lift.manualLiftDown();

        }

        if (gamepad1.right_trigger>0.1){
            //intake
        } else if (gamepad1.left_trigger>0.1){
            // eject
        }
        if (gamepad1.dpad_right){
            // move climber down
        } else if (gamepad1.dpad_left){
            //move climber up
        }
        if (gamepad1.dpad_down){
            robot.lift.downOnePixel();
        } else if (gamepad1.dpad_up){
            robot.lift.upOnePixel();
        }
        if (gamepad1.a){
            //release  right pixel from grabber
        }
        if (gamepad1.x){
            //release left pixel from grabber
        }
        if (gamepad1.y){
            robot.lift.goToFloor();
        } else if (gamepad1.b){
            if (robot.lift.manipulatorPosition == Lift.LiftPositions.LOW_POSITION){
                robot.lift.goToLow();
            } else if (robot.lift.manipulatorPosition == Lift.LiftPositions.MIDDLE_POSITION){
                robot.lift.goToMiddle();
            } else if (robot.lift.manipulatorPosition == Lift.LiftPositions.TOP_POSITION){
                robot.lift.goToTop();
            } else if (robot.lift.manipulatorPosition == Lift.LiftPositions.FLOOR_POSITION){
                robot.lift.goToFloor();
            }
            // go to slides
        }



    }
    public void manipulatorLoop(Gamepad gamepad2){
        if(gamepad2.a){
            robot.lift.manipulatorPosition = Lift.LiftPositions.LOW_POSITION;
        } else if(gamepad2.x) {
            robot.lift.manipulatorPosition = Lift.LiftPositions.MIDDLE_POSITION;

        } else if(gamepad2.y){
            robot.lift.manipulatorPosition = Lift.LiftPositions.TOP_POSITION;
        } else if (gamepad2.b){
            robot.lift.manipulatorPosition = Lift.LiftPositions.FLOOR_POSITION;
        }


    }
}
