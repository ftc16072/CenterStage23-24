package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;

import java.util.List;

public class Hang implements Mechanism {
    Servo hangServo;
    @Override
    public void init(HardwareMap hwMap) {
        hangServo = hwMap.get(Servo.class, "hang");
    }
    public void hang(){
        hangServo.setPosition(0);
    }
    public void reset(){
        hangServo.setPosition(1);
    }

    @Override
    public List<QQtest> getTests() {
        return null;
    }
}
