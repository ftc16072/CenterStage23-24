package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestServo;

import java.util.Collections;
import java.util.List;

@Config
public class Drone implements Mechanism {
    public static  double DRONE_RELEASE = 0.2;
    public static double DRONE_HOLD = 0;
    private Servo droneServo;

    @Override
    public void init(HardwareMap hwMap) {
        droneServo = hwMap.get(Servo.class, "drone_servo");
        hold();
    }

    public void release() {
        droneServo.setPosition(DRONE_RELEASE);
    }
    public void hold() {
        droneServo.setPosition(DRONE_HOLD);
    }

    @Override
    public List<QQtest> getTests() {
        return Collections.singletonList(
                new TestServo("droneServo", DRONE_RELEASE, DRONE_HOLD, droneServo)
        );
    }
}
