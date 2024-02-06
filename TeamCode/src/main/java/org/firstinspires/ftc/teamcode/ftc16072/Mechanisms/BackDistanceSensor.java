package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ThreadPool;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestDistanceSensor;

import java.util.Collections;
import java.util.List;

public class BackDistanceSensor implements Mechanism{
    DistanceSensor distanceSensor;
    @Override
    public void init(HardwareMap hwMap) {
        distanceSensor = hwMap.get(DistanceSensor.class, "back_distance_sensor");

    }
public double distanceToBackboard(){
        return distanceSensor.getDistance(DistanceUnit.CM);
}
    @Override
    public List<QQtest> getTests() {
        return Collections.singletonList(new TestDistanceSensor("distance sensor",distanceSensor));
    }
}
