package org.firstinspires.ftc.teamcode.ftc16072;

import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.Camera;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.ControlHub;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.HoldingCell;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.LineDetector;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.Intake;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.MecanumDrive;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.Mechanism;
import org.firstinspires.ftc.teamcode.ftc16072.Util.Navigation;
import org.firstinspires.ftc.vision.VisionPortal;

import java.util.Arrays;
import java.util.List;

public class Robot {
    List<Mechanism> mechanisms;
    public MecanumDrive mecanumDrive;
    public Navigation nav;
    public ControlHub controlHub;
    public LineDetector lineDetector;
    public Intake intake;

    public HoldingCell holdingCell;
    public Camera cameraFront;
    public Camera cameraBack;



    public Robot() {
        cameraFront = new Camera(Camera.CameraPosition.FRONT);
        cameraBack = new Camera(Camera.CameraPosition.BACK);
        controlHub = new ControlHub();
        mecanumDrive = new MecanumDrive();
        lineDetector = new LineDetector();
        nav = new Navigation(controlHub, mecanumDrive);
        intake = new Intake();
        holdingCell = new HoldingCell();

        mechanisms = Arrays.asList(
                //mecanumDrive,
                controlHub,
                // intake,
                cameraBack,
                cameraFront
                //holdingCell
                // lineDetector
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
        cameraFront.setViewPortID(ids[0]);
        cameraBack.setViewPortID(ids[1]);

        for (Mechanism mechanism : mechanisms) {
            mechanism.init(hwMap);
        }
    }

    public List<Mechanism> getMechanismList() {
        return mechanisms;
    }
}
