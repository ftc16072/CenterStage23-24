package org.firstinspires.ftc.teamcode.ftc16072;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.Arm;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.BackDistanceSensor;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.Camera;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.Climber;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.ControlHub;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.Drone;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.HoldingCell;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.Lift;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.Intake;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.MecanumDrive;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.Mechanism;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.Placement;
import org.firstinspires.ftc.teamcode.ftc16072.Util.Navigation;
import org.firstinspires.ftc.vision.VisionPortal;

import java.util.Arrays;
import java.util.List;

public class Robot {
    List<Mechanism> mechanisms;
    public MecanumDrive mecanumDrive;
    public Navigation nav;
    public ControlHub controlHub;
    //public LineDetector lineDetector;
    public Intake intake;
    public BackDistanceSensor backDistanceSensor;

    public HoldingCell holdingCell;
    public Drone drone;
    //public Camera cameraFront;
    public Camera cameraBack;
    public Lift lift;
    public Arm arm;
    public Placement placement;
    public Climber climber;



    public Robot() {
        //cameraFront = new Camera(Camera.CameraPosition.FRONT);
        backDistanceSensor = new BackDistanceSensor();
        cameraBack = new Camera(Camera.CameraPosition.BACK);
        controlHub = new ControlHub();
        mecanumDrive = new MecanumDrive();
        nav = new Navigation(controlHub, mecanumDrive, cameraBack);
        intake = new Intake();
        holdingCell = new HoldingCell();
        lift = new Lift();
        arm = new Arm();
        placement = new Placement();
        climber = new Climber();
        drone = new Drone();


        mechanisms = Arrays.asList(
                mecanumDrive,
                drone,
                controlHub,
                intake,
                cameraBack,
                holdingCell,
                lift,
                arm,
                placement,
                climber,
                backDistanceSensor
        );
    }

    public void makeDriveOnly() {
        mechanisms = Arrays.asList(
                mecanumDrive,
                controlHub
        );
    }

    public void init(HardwareMap hwMap) {
        int[] ids = VisionPortal.makeMultiPortalView(2, VisionPortal.MultiPortalLayout.HORIZONTAL);
        //cameraFront.setViewPortID(ids[0]);
        cameraBack.setViewPortID(ids[1]);

        for (Mechanism mechanism : mechanisms) {
            mechanism.init(hwMap);
        }
    }

    public List<Mechanism> getMechanismList() {
        return mechanisms;
    }
}
