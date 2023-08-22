package org.firstinspires.ftc.teamcode.ftc16072.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.List;

@TeleOp
public class VisionBase extends OpMode{

    private AprilTagProcessor aprilTag;
    private VisionPortal visionPortal;

    @Override
    public void init() {
        aprilTag = AprilTagProcessor.easyCreateWithDefaults();

        visionPortal = visionPortal.easyCreateWithDefaults(
                hardwareMap.get(WebcamName.class, "Webcam"), aprilTag);
    }

    @Override
    public void loop() {
        telemetry.addData("Hello","World");

        List<AprilTagDetection> currentDetections = aprilTag.getDetections();

        for(AprilTagDetection detection : currentDetections) {
            //if (detection.metadata != null) {
                telemetry.addLine(String.format("\n==== (ID %d) Unknown", detection.id));
                telemetry.addLine(String.format("RPY %6.1f(DEGREE)", detection.ftcPose.yaw));
                telemetry.addLine(String.format("XYZ %6.1f %6.1f  (INCH)", detection.ftcPose.x, detection.ftcPose.y*1.1));
                telemetry.addLine(String.format("RBE %6.1f (INCH)", detection.ftcPose.range));
                telemetry.addData("id: ", detection.id);
            //}
        }

    }
}
