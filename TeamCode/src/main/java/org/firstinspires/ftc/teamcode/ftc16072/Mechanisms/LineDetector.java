package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestColorSensor;

import java.util.Collections;
import java.util.List;

public class LineDetector implements Mechanism {
    RevColorSensorV3 colorSensor;


    @Override
    public void init(HardwareMap hwMap) {
        colorSensor = hwMap.get(RevColorSensorV3.class, "line_detector");
    }


    @Override
    public List<QQtest> getTests() {
        return Collections.singletonList(new TestColorSensor("line detector", colorSensor));
    }
}
