package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestServo;

import java.util.Collections;
import java.util.List;

public class PixelServo implements Mechanism{
    public static final double RELEASE_POSITION= 1; // needs to be tuned
    Servo pixelServo;
    @Override
    public void init(HardwareMap hwMap) {
        pixelServo = hwMap.get(Servo.class, "pixel_servo");

    }
    public void releasePixel(){
        pixelServo.setPosition(RELEASE_POSITION);
    }


    @Override
    public List<QQtest> getTests() {
        return Collections.singletonList(new TestServo("Pixel Servo", 1, 0.5, pixelServo));
    }
}   
