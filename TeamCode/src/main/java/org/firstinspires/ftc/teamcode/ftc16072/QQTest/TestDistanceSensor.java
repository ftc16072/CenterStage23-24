package org.firstinspires.ftc.teamcode.ftc16072.QQTest;

import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import java.io.DataInput;

public class TestDistanceSensor extends QQtest {

    DistanceSensor distanceSensor;
    public TestDistanceSensor(String name, DistanceSensor distanceSensor){
        super(name);
        this.distanceSensor = distanceSensor;




    }
    @Override
    public void run(boolean on, Telemetry telemetry) {
        telemetry.addData("DistanceSensor: ", distanceSensor.getDistance(DistanceUnit.CM));


    }
}
