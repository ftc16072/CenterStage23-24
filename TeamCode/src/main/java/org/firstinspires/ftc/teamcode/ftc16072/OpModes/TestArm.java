package org.firstinspires.ftc.teamcode.ftc16072.OpModes;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.ftc16072.Robot;

@TeleOp()
public class TestArm extends OpMode {
    Robot robot = new Robot();

    @Override
    public void init() {
        robot.init(hardwareMap);
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
    }

    @Override
    public void loop() {
        if(gamepad1.left_bumper){
            robot.arm.setArmIntakePos();
        }
        else if(gamepad1.right_bumper){
            robot.arm.setArmPlacingPos();
        }
        else if(gamepad1.a) {
            robot.arm.findServoLocation();
        }
        else if(gamepad1.x){
            robot.arm.setWristPlacingPos();
        }
        else if(gamepad1.b){
            robot.arm.setWristIntakePos();
        }
        robot.arm.update(telemetry);
    }
}
