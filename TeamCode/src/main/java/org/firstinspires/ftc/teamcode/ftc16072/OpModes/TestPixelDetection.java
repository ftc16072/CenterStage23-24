package org.firstinspires.ftc.teamcode.ftc16072.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
@TeleOp
public class TestPixelDetection extends VisionBase{
    @Override
    public void init() {
        super.init();
    }
    public void init_loop(){
        robot.cameraBack.telemetryRobotPos(telemetry);

    }
    @Override
    public void loop() {


    }
}
