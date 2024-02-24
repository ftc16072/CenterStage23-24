package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import static com.qualcomm.hardware.rev.RevHubOrientationOnRobot.xyzOrientation;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.VoltageSensor;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestGyro;

import java.util.Collections;
import java.util.List;

public class ControlHub implements Mechanism {
    IMU gyro;
    double offsetDegrees;
    public VoltageSensor batteryVoltageSensor;

    @Override
    public void init(HardwareMap hwMap) {
        gyro = hwMap.get(IMU.class, "imu");
        batteryVoltageSensor = hwMap.voltageSensor.iterator().next();

        double xRotation = 60;  // enter the desired X rotation angle here.
        double yRotation = 0;  // enter the desired Y rotation angle here.
        double zRotation = 90;  // enter the desired Z rotation angle here.

        Orientation hubRotation = xyzOrientation(xRotation, yRotation, zRotation);

        // Now initialize the IMU with this mounting orientation
        RevHubOrientationOnRobot orientationOnRobot = new RevHubOrientationOnRobot(hubRotation);

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
        return "Control Hub";
    }

    public double getHeading(AngleUnit angleUnit) {
        YawPitchRollAngles angles = gyro.getRobotYawPitchRollAngles();
        double newDegrees = angles.getYaw(AngleUnit.DEGREES) - offsetDegrees;
        return angleUnit.fromDegrees(newDegrees);
    }

    public void resetHeading(double angle, AngleUnit angleUnit) {
        offsetDegrees = angleUnit.toDegrees(angle);
        gyro.resetYaw();
    }
}
