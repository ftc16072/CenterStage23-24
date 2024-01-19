package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestServo;

import java.util.Arrays;
import java.util.List;

@Config
public class Placement implements Mechanism{


    public static double LEFT_SERVO_GRAB_POSITION = 0.25;
    //TODO add final after tuning
    public static double LEFT_SERVO_EJECT_POSITION = 0.1    ;
    public static double RIGHT_SERVO_GRAB_POSITION = 0.45;
    //TODO add final after tuning
    public static  double RIGHT_SERVO_EJECT_POSITION = 0.5;
    public static double RIGHT_SERVO_LIFTDOWN_POSITION = 0.6;
    public static double LEFT_SERVO_LIFTDOWN_POSITION= 0;
    Servo rightPlacement;
    Servo leftPlacement;
    @Override
    public void init(HardwareMap hwMap) {
        leftPlacement= hwMap.get(Servo.class,"left_placement");
        rightPlacement = hwMap.get(Servo.class,"right_placement");



    }
    public void leftServoGrab(){
        leftPlacement.setPosition(LEFT_SERVO_GRAB_POSITION);
    }
    public void rightServoGrab(){
        rightPlacement.setPosition(RIGHT_SERVO_GRAB_POSITION);
    }
    public void leftServoEject(){
        leftPlacement.setPosition(LEFT_SERVO_EJECT_POSITION);
    } public void rightServoEject(){
        rightPlacement.setPosition(RIGHT_SERVO_EJECT_POSITION);
    }
    public void servosGoToLiftDownPosition(){
        leftPlacement.setPosition(LEFT_SERVO_LIFTDOWN_POSITION);
        rightPlacement.setPosition(RIGHT_SERVO_LIFTDOWN_POSITION);
    }


    @Override
    public List<QQtest> getTests() {
        return Arrays.asList(
                new TestServo("left_placement", LEFT_SERVO_GRAB_POSITION, LEFT_SERVO_EJECT_POSITION,leftPlacement),
                new TestServo("right_placement", RIGHT_SERVO_GRAB_POSITION, RIGHT_SERVO_EJECT_POSITION,rightPlacement)


        );
    }
}
