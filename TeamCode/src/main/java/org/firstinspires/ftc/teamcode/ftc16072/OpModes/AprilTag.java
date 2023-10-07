package org.firstinspires.ftc.teamcode.ftc16072.OpModes;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.List;

@Config
@TeleOp
public class AprilTag extends OpMode {
    private AprilTagProcessor aprilTag;
    private VisionPortal visionPortal;

    @Override
    public void init() {
        aprilTag = AprilTagProcessor.easyCreateWithDefaults();

        visionPortal = VisionPortal.easyCreateWithDefaults(
                hardwareMap.get(WebcamName.class, "Webcam"), aprilTag);
    }

    @Override
    public void loop() {

        List<AprilTagDetection> currentDetections = aprilTag.getDetections();

        for (AprilTagDetection detection : currentDetections) {
            telemetry.addLine(String.format("\n==== (ID %d)", detection.id));
            telemetry.addLine(String.format("RPY %6.1f(DEGREE)", detection.ftcPose.yaw));
            telemetry.addLine(String.format("XYZ %6.1f %6.1f  (INCH)", detection.ftcPose.x, detection.ftcPose.y));
            telemetry.addLine(String.format("RBE %6.1f (INCH)", detection.ftcPose.range));
        }

    }
}
