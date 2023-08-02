package org.firstinspires.ftc.teamcode.ftc16072;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.ControlHub;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.MecanumDrive;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.Mechanism;
import org.firstinspires.ftc.teamcode.ftc16072.Util.Navigation;

import java.util.Arrays;
import java.util.List;

public class Robot {
    List<Mechanism> mechanisms;
    public MecanumDrive mecanumDrive;
    public Navigation nav;
    ControlHub controlHub;

    public Robot() {
        controlHub = new ControlHub();
        mecanumDrive = new MecanumDrive();
        nav = new Navigation(controlHub, mecanumDrive);

        mechanisms = Arrays.asList(
                mecanumDrive,
                controlHub
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
