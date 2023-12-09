package org.firstinspires.ftc.teamcode.ftc16072.OpModes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.ftc16072.Robot;
import org.firstinspires.ftc.teamcode.ftc16072.Util.BlackBoard;

/**
 * base opmode each other opmode should be based on
 * for behavior trees
 */

abstract public class QQOpMode extends OpMode {

    public Robot robot = new Robot();
    public BlackBoard board = new BlackBoard();

    /**
     * every opmode initializes robot with hardware map
      */
    public void init(){


        robot.init(hardwareMap);
    }

}
