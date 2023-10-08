package org.firstinspires.ftc.teamcode.ftc16072.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.ftc16072.Util.TeamPropDetector;
import org.firstinspires.ftc.vision.VisionPortal;

@TeleOp
public class VisionBase extends OpMode{
    TeamPropDetector teamPropDetector = new TeamPropDetector();
    private VisionPortal visionPortal;

    @Override
    public void init() {
        WebcamName webcamName= hardwareMap.get(WebcamName.class,"Webcam");
        visionPortal = VisionPortal.easyCreateWithDefaults(webcamName,teamPropDetector);
    }

    public void init_loop(){
        int parkingZone = teamPropDetector.getParkingZone();
        telemetry.addData("parking zone", parkingZone);
    }

    public void start(){
        visionPortal.stopStreaming();
    }
    
    @Override
    public void loop() {
    }
}
