package org.firstinspires.ftc.teamcode.ftc16072.QQTest;

import com.qualcomm.hardware.rev.RevColorSensorV3;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class TestColorSensor extends QQtest {
    RevColorSensorV3 colorSensor;

    public TestColorSensor(String name, RevColorSensorV3 colorSensor) {
        super(name);
        this.colorSensor = colorSensor;
    }

    @Override
    public void run(boolean on, Telemetry telemetry) {
        telemetry.addData(name + " red", colorSensor.red());
        telemetry.addData(name + " green", colorSensor.green());
        telemetry.addData(name + " blue", colorSensor.blue());
        telemetry.addData(name + " inch", colorSensor.getDistance(DistanceUnit.INCH));
        telemetry.addData(name + " cm", colorSensor.getDistance(DistanceUnit.CM));
    }
}
