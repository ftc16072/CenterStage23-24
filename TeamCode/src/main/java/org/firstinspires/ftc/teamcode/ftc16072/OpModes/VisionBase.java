package org.firstinspires.ftc.teamcode.ftc16072.OpModes;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.ftc16072.Util.TeamPropDetector;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.VisionProcessor;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.List;
@Config
@TeleOp
public class VisionBase extends OpMode{

    public static double y_multiplier = 1.2;
    //private AprilTagProcessor aprilTag;

    TeamPropDetector teamPropDetector = new TeamPropDetector();


    private VisionPortal visionPortal;

    @Override
    public void init() {
        WebcamName webcamName= hardwareMap.get(WebcamName.class,"Webcam 1");
        visionPortal = VisionPortal.easyCreateWithDefaults(webcamName,teamPropDetector);
        /*aprilTag = AprilTagProcessor.easyCreateWithDefaults();

        visionPortal = VisionPortal.easyCreateWithDefaults(
                hardwareMap.get(WebcamName.class, "Webcam"), aprilTag);

         */
    }
    public void init_loop(){
        int parkingZone = teamPropDetector.getParkingZone();
        telemetry.addData("parking zone", parkingZone);
    }
    public void start(){
        visionPortal.resumeStreaming();
    }
    @Override
    public void loop() {

        /*
        telemetry.addData("Hello","World");

        List<AprilTagDetection> currentDetections = aprilTag.getDetections();

        for(AprilTagDetection detection : currentDetections) {
            //if (detection.metadata != null) {
                telemetry.addLine(String.format("\n==== (ID %d) Unknown", detection.id));
                telemetry.addLine(String.format("RPY %6.1f(DEGREE)", detection.ftcPose.yaw));
                telemetry.addLine(String.format("XYZ %6.1f %6.1f  (INCH)", detection.ftcPose.x, detection.ftcPose.y));
                telemetry.addLine(String.format("RBE %6.1f (INCH)", detection.ftcPose.range));
                telemetry.addData("id: ", detection.id);
            //}
        }

         */

    }
}
