package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestMotor;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestServo;

import java.util.Arrays;
import java.util.List;

public class Arm implements Mechanism{
    DcMotorEx arm;
    Servo wrist;
    @Override
    public void init(HardwareMap hwMap) {
        arm = hwMap.get(DcMotorEx.class, "arm");
        wrist = hwMap.get(Servo.class, "wrist");
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public boolean goToTop(){

        return goTo(40);
    }

    public boolean goToBottom(){
        return false;
    }

    public boolean manualUp(){
        return false;
    }

    public boolean manualDown(){
        return false;
    }


    public boolean goTo(int position){
        moveMotor(position);
        moveServo(position);
        return true;


    }
    public void moveMotor(int position){
        arm.setTargetPosition(convertToMotorTicks(position));
        wrist.setPosition(convertToServoPosition(position));

    }
    public void moveServo(int position){


    }
    public int convertToMotorTicks(int angle){
        return angle*223;
    }
    public int convertToServoPosition(int angle){
        return angle/300;
    }


    @Override
    public List<QQtest> getTests() {
        return Arrays.asList(
                new TestMotor("Arm", 0.2, arm),
                new TestServo("Wrist", 0, 0.5, wrist));
    }


}
