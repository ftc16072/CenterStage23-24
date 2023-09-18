package org.firstinspires.ftc.teamcode.ftc16072.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.ftc16072.Robot;
@TeleOp
public class Ri3w extends OpMode {
    Robot robot = new Robot();
    public void init() {
  robot.init(hardwareMap);


    }

    @Override
    public void loop() {
robot.intake.stop();
    robot.mecanumDrive.move(-gamepad1.left_stick_y,
                gamepad1.left_stick_x,
                gamepad1.right_stick_x);
    if (gamepad1.a){
    robot.intake.run();
    }
    else if (gamepad1.b){
    robot.intake.eject();
    }

    }
}
