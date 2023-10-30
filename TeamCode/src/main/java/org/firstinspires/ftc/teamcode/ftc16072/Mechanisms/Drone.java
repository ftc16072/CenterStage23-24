package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestServo;

import java.util.Arrays;
import java.util.List;

public class Drone implements Mechanism{
    private Servo droneServo;
    @Override
    public void init(HardwareMap hwMap) {
        droneServo = hwMap.get(Servo.class,"drone_servo");

    }

    @Override
    public List<QQtest> getTests() {
        return Arrays.asList(
                new TestServo("droneServo",0.5,0,droneServo)
        );
    }
}
