package org.firstinspires.ftc.teamcode.ftc16072.Util;

import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.Lift;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.Placement;
import org.firstinspires.ftc.teamcode.ftc16072.Robot;

public class PlacementControl {
    Placement placement;
    Lift lift;

    public PlacementControl(Robot robot) {
        placement = robot.placement;
        lift = robot.lift;
    }


    public void updatePlacement() {
        if (lift.currentPosition() > 100) {
            placement.rightServoGrab();
            placement.leftServoGrab();

        } else {
            //
        }


    }
}
