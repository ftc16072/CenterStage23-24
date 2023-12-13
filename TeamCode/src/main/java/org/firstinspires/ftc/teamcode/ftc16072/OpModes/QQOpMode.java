package org.firstinspires.ftc.teamcode.ftc16072.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.ftc16072.Robot;
import org.firstinspires.ftc.teamcode.ftc16072.Util.BlackBoard;
import org.firstinspires.ftc.teamcode.ftc16072.Util.LiftControl;

/**
 * base opmode each other opmode should be based on
 * for behavior trees
 */

abstract public class QQOpMode extends OpMode {
    public Robot robot = new Robot();
    public LiftControl liftControl = new LiftControl(robot);

    public BlackBoard board = new BlackBoard();

    /**
     * every opmode initializes robot with hardware map
      */
    public void init(){
        robot.init(hardwareMap);
    }


}
