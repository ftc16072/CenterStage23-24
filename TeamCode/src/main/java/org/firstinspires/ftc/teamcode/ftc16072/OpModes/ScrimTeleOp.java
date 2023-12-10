package org.firstinspires.ftc.teamcode.ftc16072.OpModes;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trees.TeleopTree;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.Lift;
@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class ScrimTeleOp extends  QQOpMode{

    Node root = TeleopTree.root();

    boolean done;


    @Override
    public void loop() {
        if(!done){
            Node.State state = root.tick(this);
            if(state == Node.State.SUCCESS){
                done = true;
            }
        }
        driverLoop(gamepad1);
        manipulatorLoop(gamepad2);

    }

    public void driverLoop(Gamepad gamepad1){


        if (gamepad1.right_bumper){
            liftControl.manualLiftUp();
        } else if (gamepad1.left_bumper){
            liftControl.manualLiftDown();

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
            liftControl.downOnePixel();
        } else if (gamepad1.dpad_up){
            liftControl.upOnePixel();
        }
        if (gamepad1.a){
            //release  right pixel from grabber
        }
        if (gamepad1.x){
            //release left pixel from grabber
        }
        if (gamepad1.y){
            liftControl.goToFloor();
        } else if (gamepad1.b){
            if (liftControl.atPosition(Lift.LiftPositions.LOW_POSITION)){
                robot.arm.goToPlacingPosition();
                liftControl.goToLow();
            } else if (liftControl.atPosition(Lift.LiftPositions.MIDDLE_POSITION)){
                robot.arm.goToPlacingPosition();
                liftControl.goToMiddle();
            } else if (liftControl.atPosition(Lift.LiftPositions.TOP_POSITION)){
                robot.arm.goToPlacingPosition();
                liftControl.goToTop();
            } else if (liftControl.atPosition(Lift.LiftPositions.FLOOR_POSITION)){
                robot.arm.goToIntakePosition();
                liftControl.goToFloor();
            }
            // go to slides
        }



    }
    public void manipulatorLoop(Gamepad gamepad2){
        if(gamepad2.a){
            liftControl.setManipulatorPosition(Lift.LiftPositions.LOW_POSITION);
        } else if(gamepad2.x) {
            liftControl.setManipulatorPosition(Lift.LiftPositions.MIDDLE_POSITION);

        } else if(gamepad2.y){
            liftControl.setManipulatorPosition(Lift.LiftPositions.TOP_POSITION);
        } else if (gamepad2.b){
            liftControl.setManipulatorPosition(Lift.LiftPositions.FLOOR_POSITION);
        }


    }
}
