package org.firstinspires.ftc.teamcode.ftc16072.OpModes;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;
@TeleOp
@Config
public class TestingRobotTeleOp extends QQOpMode {
    FtcDashboard dashboard;

    public void init(){
        robot.init(hardwareMap);
        dashboard = FtcDashboard.getInstance();
        telemetry = dashboard.getTelemetry();


    }
    @Override
    public void loop() {
        if (gamepad1.a){
            robot.arm.goToPlacingPosition();
        } else {
            robot.arm.goToIntakePosition();
        }  if (gamepad1.left_trigger>0.2){
            robot.placement.leftServoEject();
        } else {
            robot.placement.leftServoGrab();

        } if (gamepad1.right_trigger>0.2){
            robot.placement.rightServoEject();
        } else {
            robot.placement.rightServoGrab();

        }

        if (gamepad1.dpad_down){
            robot.lift.manualLiftDown();
        } else if (gamepad1.dpad_up){
            robot.lift.manualLiftUp();
        } if (gamepad1.x){
            robot.lift.goToMiddle();
        } else if (gamepad1.b){
            robot.lift.goToLow();
        }



        telemetry.addData("lift motor power ",robot.lift.getPower());
        telemetry.addData("lift desired Position", robot.lift.getDesiredPosition());
        telemetry.addData("lift current position", robot.lift.currentPosition());
        robot.lift.update(telemetry);




    }
}
