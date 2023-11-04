package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;


import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestCamera;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.Collections;
import java.util.List;

//TODO: Get to work with multiple cameras
public class Camera implements Mechanism{
    public static final int FRONT_CAMERA_X = 5;
    public static final int FRONT_CAMERA_Y = 4;
    public static final int FRONT_CAMERA_Z = 3;
    public static final int BACK_CAMERA_X = 1;
    public static final int BACK_CAMERA_Y = 2;
    public static final int BACK_CAMERA_Z = 3;

    private AprilTagProcessor aprilTag;

    private VisionPortal visionPortal;

    String cameraName;
    Position position;
    WebcamName webcamName;
    public enum CameraPosition {
        FRONT, BACK
    }
    public Camera(CameraPosition position){
        if(position==CameraPosition.FRONT){
            cameraName = "FrontCamera";
            this.position = new Position(DistanceUnit.CM, FRONT_CAMERA_X, FRONT_CAMERA_Y, FRONT_CAMERA_Z, 0);
        } else{
            cameraName = "BackCamera";
            this.position = new Position(DistanceUnit.CM, BACK_CAMERA_X, BACK_CAMERA_Y, BACK_CAMERA_Z, 0);

        }

    }
    @Override
    public void init(HardwareMap hwMap) {
        aprilTag = AprilTagProcessor.easyCreateWithDefaults();

        webcamName= hwMap.get(WebcamName.class,cameraName);
        visionPortal = VisionPortal.easyCreateWithDefaults(webcamName,aprilTag);
    }
    public List<AprilTagDetection> getAprilTagDetections(){ // return robot position
        return aprilTag.getDetections();
    }

    @Override
    public List<QQtest> getTests() {
        return Collections.singletonList(new TestCamera(cameraName,webcamName ));
    }
    public void stopStreaming(){
        visionPortal.stopStreaming();
    }
}