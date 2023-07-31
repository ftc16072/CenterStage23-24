package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestGyro;

import java.util.Collections;
import java.util.List;

public class Gyro implements Mechanism {
    IMU gyro;

    @Override
    public void init(HardwareMap hwMap) {
        gyro = hwMap.get(IMU.class, "imu");
        RevHubOrientationOnRobot.LogoFacingDirection logoDirection = RevHubOrientationOnRobot.LogoFacingDirection.RIGHT;
        RevHubOrientationOnRobot.UsbFacingDirection usbDirection = RevHubOrientationOnRobot.UsbFacingDirection.FORWARD;

        RevHubOrientationOnRobot orientationOnRobot = new RevHubOrientationOnRobot(logoDirection, usbDirection);

        // Now initialize the IMU with this mounting orientation
        // Note: if you choose two conflicting directions, this initialization will cause a code exception.
        gyro.initialize(new IMU.Parameters(orientationOnRobot));
    }

    @Override
    public List<QQtest> getTests() {
        return Collections.singletonList(new TestGyro("IMU", gyro));
    }

    @Override
    public String getName() {
        return "gyro";
    }

    public double getHeading(AngleUnit angleUnit) {
        YawPitchRollAngles angles = gyro.getRobotYawPitchRollAngles();
        return angles.getYaw(angleUnit);
    }
}
