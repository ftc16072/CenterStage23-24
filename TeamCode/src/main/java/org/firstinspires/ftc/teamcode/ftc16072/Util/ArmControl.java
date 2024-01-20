package org.firstinspires.ftc.teamcode.ftc16072.Util;

import org.firstinspires.ftc.teamcode.ftc16072.Robot;

public class ArmControl {
   public int safePosition = 600;

    public void updateArm (Robot robot){
        if (robot.lift.currentPosition() > safePosition){
            robot.arm.goToPlacingPosition();
        } else{
            robot.arm.goToIntakePosition();
        }
    }
}
