package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestServo;

import java.util.Collections;
import java.util.List;

public class Drone implements Mechanism {
    public static final double DRONE_RELEASE = 0.4;
    private Servo droneServo;

    @Override
    public void init(HardwareMap hwMap) {
        droneServo = hwMap.get(Servo.class, "drone_servo");

    }

    public void releaseDrone() {
        droneServo.setPosition(DRONE_RELEASE);
    }

    @Override
    public List<QQtest> getTests() {
        return Collections.singletonList(
                new TestServo("droneServo", 0.5, 0, droneServo)
        );
    }
}
