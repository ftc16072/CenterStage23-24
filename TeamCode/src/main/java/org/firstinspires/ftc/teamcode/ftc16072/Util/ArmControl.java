package org.firstinspires.ftc.teamcode.ftc16072.Util;

import org.firstinspires.ftc.teamcode.ftc16072.Robot;

public class ArmControl {
   public final int SAFE_POSITION = 600;

    public void updateArm (Robot robot){
        if (robot.lift.currentPosition() > SAFE_POSITION){
            robot.arm.goToPlacingPosition();
        } else{
            robot.arm.goToIntakePosition();
        }
    }
}
