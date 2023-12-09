package org.firstinspires.ftc.teamcode.ftc16072;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.Arm;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.Camera;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.ControlHub;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.HoldingCell;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.Intake;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.Lift;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.MecanumDrive;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.Mechanism;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.Placement;
import org.firstinspires.ftc.teamcode.ftc16072.Util.Navigation;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.Intake;

import java.util.Arrays;
import java.util.List;

public class Robot {
    List<Mechanism> mechanisms;
    public MecanumDrive mecanumDrive;
    public Navigation nav;
    public ControlHub controlHub;
    public Intake intake;
    public Camera cameraBack;
    public Camera cameraFront;
    public HoldingCell holdingCell;

    public Placement placement;

    public Arm arm;
    public Lift lift;
    public Robot() {
        controlHub = new ControlHub();
        mecanumDrive = new MecanumDrive();
        cameraBack = new Camera(Camera.CameraPosition.BACK);
        cameraFront = new Camera(Camera.CameraPosition.FRONT);
        holdingCell = new HoldingCell();
        nav = new Navigation(controlHub, mecanumDrive,cameraFront,cameraBack);
        intake = new Intake();
        arm = new Arm();
        lift = new Lift();
        placement = new Placement();
        mechanisms = Arrays.asList(
                mecanumDrive,
                controlHub,
                intake,
                arm,
                lift,
                cameraFront,
                cameraBack,
                holdingCell,
                placement
        );
    }

    public void makeDriveOnly() {
        mechanisms = Arrays.asList(
                mecanumDrive,
                controlHub
        );
    }

    public void init(HardwareMap hwMap) {
        for (Mechanism mechanism : mechanisms) {
            mechanism.init(hwMap);
        }
    }

    public List<Mechanism> getMechanismList() {
        return mechanisms;
    }
}
