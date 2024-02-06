package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;

import java.util.List;

public class BackDistanceSensor implements Mechanism{
    DistanceSensor distanceSensor;
    @Override
    public void init(HardwareMap hwMap) {
        distanceSensor = hwMap.get(DistanceSensor.class, "distanceSensor");

    }
public double distanceToBackboard(){
        return distanceSensor.getDistance(DistanceUnit.CM);
}
    @Override
    public List<QQtest> getTests() {
        return null;
    }
}
