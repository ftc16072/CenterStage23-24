package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.hardware.HardwareMap;


import android.util.Size;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestCamera;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

//TODO: Get to work with multiple cameras
public class Camera implements Mechanism{
    public static final int FRONT_CAMERA_X = 5;
    public static final int FRONT_CAMERA_Y = 4;
    public static final int FRONT_CAMERA_Z = 3;
    public static final int BACK_CAMERA_X = 1;
    public static final int BACK_CAMERA_Y = 2;
    public static final int BACK_CAMERA_Z = 3;
    public enum TeamColor{
        BLUE,
        RED,
    }
    public enum AprilTagIds{
        TAG1,
        TAG2,
        TAG3,
        TAG4,
        TAG5,
        TAG6,

    }
    public void fillPositions(TeamColor teamColor){
        if (teamColor == TeamColor.RED){
            aprilTagPositions.clear();
            aprilTagPositions.put(1, new Pose2d(1,2,3));
            aprilTagPositions.put(2, new Pose2d(1,2,3));
            aprilTagPositions.put(3, new Pose2d(1,2,3));
            aprilTagPositions.put(4, new Pose2d(1,2,3));
            aprilTagPositions.put(5, new Pose2d(1,2,3));
            aprilTagPositions.put(5, new Pose2d(1,2,3));

        } else {
            aprilTagPositions.clear();
            aprilTagPositions.put(1, new Pose2d(1,2,3));
            aprilTagPositions.put(2, new Pose2d(1,2,3));
            aprilTagPositions.put(3, new Pose2d(1,2,3));
            aprilTagPositions.put(4, new Pose2d(1,2,3));
            aprilTagPositions.put(5, new Pose2d(1,2,3));
            aprilTagPositions.put(5, new Pose2d(1,2,3));

        }

    }
    Hashtable<Integer, Pose2d> aprilTagPositions = new Hashtable<>();

    private AprilTagProcessor aprilTag;

    private VisionPortal visionPortal;

    String cameraName;
    Position position;
    WebcamName webcamName;
    int viewPortID;

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
    public void setViewPortID(int viewPortID){
        this.viewPortID = viewPortID;
    }

    @Override
    public void init(HardwareMap hwMap) {
        aprilTag = new AprilTagProcessor.Builder()
                .setDrawAxes(true)
                .setDrawTagID(true)
                .setDrawTagOutline(true)
                .setLensIntrinsics(825.125, 825.125, 287.391, 219.223)
                .build();

        webcamName= hwMap.get(WebcamName.class,cameraName);
        visionPortal = new VisionPortal.Builder().setCamera(hwMap.get(WebcamName.class, cameraName))
                            .setCameraResolution(new Size(640, 480))
                            .setLiveViewContainerId(viewPortID)
                            .addProcessor(aprilTag)
                            .build();
    }

    public List<AprilTagDetection> getAprilTagDetections(){ // return robot position
        return aprilTag.getDetections();
    }
    // TODO this program takes the first april tag reading. it needs to be able to sort through multiple ones
    // TODO getY, getX, and getHeading functions are all aprilTag relavtive, not field. this needs to be changed

    public Pose2d getPose(){
        List<AprilTagDetection> detections = aprilTag.getDetections();
        AprilTagDetection detection = detections.get(1);
        Pose2d aprilTagLocation = aprilTagPositions.get(detection.id);

        return new Pose2d(aprilTagLocation.getX()+detection.ftcPose.y, aprilTagLocation.getY()+detection.ftcPose.x,aprilTagLocation.getHeading()+detection.ftcPose.yaw);

    }
    public AprilTagDetection selectTag(List<AprilTagDetection> detections ){
        for (AprilTagDetection detection: detections){
            //detection is smallest

        }
    }
    public boolean isTagDetected(){
        return (aprilTag.getDetections().size() != 0);
    }

    @Override
    public List<QQtest> getTests() {
        return Collections.singletonList(new TestCamera(cameraName,webcamName ));
    }
    public void stopStreaming(){
        visionPortal.stopStreaming();
    }
}
