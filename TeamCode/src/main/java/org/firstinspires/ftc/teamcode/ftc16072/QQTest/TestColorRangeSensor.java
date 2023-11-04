package org.firstinspires.ftc.teamcode.ftc16072.QQTest;

import android.graphics.Color;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.hardware.ColorRangeSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class TestColorRangeSensor extends QQtest {
    ColorRangeSensor colorRangeSensor;

    public TestColorRangeSensor(String name, ColorRangeSensor colorRangeSensor) {
        super(name);
        this.colorRangeSensor = colorRangeSensor;
    }

    @Override
    public void run(boolean on, Telemetry telemetry) {
        telemetry.addData(name + " red", colorRangeSensor.red());
        telemetry.addData(name + " green", colorRangeSensor.green());
        telemetry.addData(name + " blue", colorRangeSensor.blue());
        telemetry.addData(name + " inch", colorRangeSensor.getDistance(DistanceUnit.INCH));
        telemetry.addData(name + " cm", colorRangeSensor.getDistance(DistanceUnit.CM));
    }
}
