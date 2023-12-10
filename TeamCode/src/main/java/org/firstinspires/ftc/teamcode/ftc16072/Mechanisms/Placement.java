package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestServo;

import java.util.Arrays;
import java.util.List;

public class Placement implements Mechanism{
    public static final int PLACEMENT_GRAB = 29812;
    public static final int PLACEMENT_EJECT = 23984;
    Servo rightPlacement;
    Servo leftPlacement;
    @Override
    public void init(HardwareMap hwMap) {
        leftPlacement= hwMap.get(Servo.class,"left_placement");
        rightPlacement = hwMap.get(Servo.class,"right_placement");


    }
    public void leftServoGrab(){
        leftPlacement.setPosition(PLACEMENT_GRAB);
    }
    public void rightServoGrab(){
        rightPlacement.setPosition(PLACEMENT_GRAB);
    }
    public void leftServoEject(){
        leftPlacement.setPosition(PLACEMENT_EJECT);
    } public void rightServoEject(){
        rightPlacement.setPosition(PLACEMENT_EJECT);
    }


    @Override
    public List<QQtest> getTests() {
        return Arrays.asList(
                new TestServo("right_placement", 0.5,0, rightPlacement),
                new TestServo("left_placement", 0.5,0,leftPlacement)
        );
    }
}
