package org.firstinspires.ftc.teamcode.ftc16072.OpModes;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.ftc16072.Util.TeamPropDetector;
import org.firstinspires.ftc.teamcode.ftc16072.Util.TeamPropLocation;
import org.firstinspires.ftc.vision.VisionPortal;

abstract public class VisionBase extends QQOpMode{
    TeamPropDetector teamPropDetector = new TeamPropDetector();
    private VisionPortal visionPortal;

    @Override
    public void init() {
        super.init();
        WebcamName webcamName= hardwareMap.get(WebcamName.class,"Webcam");
        visionPortal = VisionPortal.easyCreateWithDefaults(webcamName,teamPropDetector);
    }

    public void init_loop(){
        TeamPropLocation parkingZone = teamPropDetector.getPropLocation();
        telemetry.addData("parking zone", parkingZone);
        board.add("proplocation", parkingZone);
    }

    public void start(){
        visionPortal.stopStreaming();
    }

}
