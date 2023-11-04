package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestServo;

import java.util.Arrays;
import java.util.List;

public class Placement implements Mechanism{
    Servo rightPlacement;
    Servo leftPlacement;
    @Override
    public void init(HardwareMap hwMap) {
        leftPlacement= hwMap.get(Servo.class,"left_placement");
        rightPlacement = hwMap.get(Servo.class,"right_placement");


    }

    @Override
    public List<QQtest> getTests() {
        return Arrays.asList(
                new TestServo("right placement", 0.5,0,rightPlacement),
                new TestServo("right placement", 0.5,0,rightPlacement)
        );
    }
}
