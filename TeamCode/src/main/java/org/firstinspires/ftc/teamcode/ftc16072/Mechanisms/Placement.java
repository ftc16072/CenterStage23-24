package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestServo;

import java.util.Arrays;
import java.util.List;

public class Placement implements Mechanism{
    public static final double LEFT_SERVO_GRAB_POSITION = 0.63;
    public static final double LEFT_SERVO_EJECT_POSITION = 0.4;
    public static final double RIGHT_SERVO_GRAB_POSITION = .4;
    public static final double RIGHT_SERVO_EJECT_POSITION = .7;

    Servo rightPlacementServo;
    Servo leftPlacementServo;
    @Override
    public void init(HardwareMap hwMap) {
        leftPlacementServo = hwMap.get(Servo.class,"left_placement");
        rightPlacementServo = hwMap.get(Servo.class,"right_placement");
    }
    public void leftServoGrab(){
        leftPlacementServo.setPosition(LEFT_SERVO_GRAB_POSITION);
    }
    public void rightServoGrab(){
        rightPlacementServo.setPosition(RIGHT_SERVO_GRAB_POSITION);
    }
    public void leftServoEject(){
        leftPlacementServo.setPosition(LEFT_SERVO_EJECT_POSITION);
    } public void rightServoEject(){
        rightPlacementServo.setPosition(RIGHT_SERVO_EJECT_POSITION);
    }

    @Override
    public List<QQtest> getTests() {
        return Arrays.asList(
                new TestServo("left_placement", LEFT_SERVO_EJECT_POSITION, LEFT_SERVO_GRAB_POSITION, leftPlacementServo),
                new TestServo("right_placement", RIGHT_SERVO_EJECT_POSITION, RIGHT_SERVO_GRAB_POSITION, rightPlacementServo)
        );
    }
}
