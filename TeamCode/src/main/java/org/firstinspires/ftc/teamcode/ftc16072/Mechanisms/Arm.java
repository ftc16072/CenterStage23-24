package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;

import java.util.List;

public class Arm implements Mechanism{

    @Override
    public void init(HardwareMap hwMap) {

    }
    public boolean goToTop(){
        return false;
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


    @Override
    public List<QQtest> getTests() {
        return null;
    }


}
