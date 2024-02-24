package org.firstinspires.ftc.teamcode.ftc16072.Util;

import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.Arm;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.Lift;

public class LiftChecker {
    Lift lift;
    Arm arm;

    public boolean isLiftSafe() {
        return arm.getArmPosition() == Arm.ArmPositions.INTAKE_POSITION;
    }


}
