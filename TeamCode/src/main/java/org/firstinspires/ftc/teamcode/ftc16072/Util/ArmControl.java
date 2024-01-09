package org.firstinspires.ftc.teamcode.ftc16072.Util;

import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.Arm;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.Lift;
import org.firstinspires.ftc.teamcode.ftc16072.Robot;

public class ArmControl {
    Arm arm;
    Lift lift;
   public int safePosition; //TODO
    public ArmControl (Robot robot){
        arm = robot.arm;
        lift = robot.lift;
    }
    public void updateArm (){
        if (lift.currentPosition() > safePosition){
            arm.goToPlacingPosition();
        } else{
            arm.goToIntakePosition();
        }

    }
}
