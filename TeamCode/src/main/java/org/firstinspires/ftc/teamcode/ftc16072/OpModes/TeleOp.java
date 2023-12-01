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

    }
    public void manipulatorLoop(Gamepad gamepad2){


    }
}
