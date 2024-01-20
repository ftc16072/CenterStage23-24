package org.firstinspires.ftc.teamcode.ftc16072.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;

import java.util.List;
import java.util.Locale;

@TeleOp

public class AprilTag extends VisionBase {

    @Override
    public void init() {
        super.init();
    }
    public void init_loop(){
        telemetry.addLine("Front Camera");
        printAprilTags(robot.cameraFront.getAprilTagDetections());
        telemetry.addLine("Back Camera");
        printAprilTags(robot.cameraBack.getAprilTagDetections());
        telemetry.addLine("------------");
    }
    public void printAprilTags( List<AprilTagDetection> detections){
        telemetry.addLine(String.format("(%d tags found)", detections.size()));
        for(AprilTagDetection detection : detections){
            telemetry.addLine(String.format(Locale.US, "(%d) XYZ - angle: %.1f %.1f %.1f %.1f", detection.id, detection.ftcPose.x,
                    detection.ftcPose.y, detection.ftcPose.z, detection.ftcPose.yaw));
        }
    }

    @Override
    public void loop() {

    }
}
