package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.qualcomm.robotcore.hardware.ColorRangeSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestColorRangeSensor;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestColorSensor;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestMotor;

import java.util.Arrays;
import java.util.List;

public class Intake implements Mechanism{

    private DcMotor intakeMotor;
    private ColorRangeSensor leftPixelCounter;
    private ColorRangeSensor rightPixelCounter;

    @Override
    public void init(HardwareMap hwMap) {
        intakeMotor = hwMap.get(DcMotor.class, "Intake_Motor");
        intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftPixelCounter = hwMap.get(ColorRangeSensor.class, "left_pixel_counter");
        rightPixelCounter = hwMap.get(ColorRangeSensor.class, "right_pixel_counter");


    }

    public List<QQtest> getTests() {
        return Arrays.asList(
                new TestMotor("Intake Left", 0.2, intakeMotor),
                new TestColorRangeSensor("left pixel detector", leftPixelCounter),
                new TestColorRangeSensor("right pixel detector", rightPixelCounter));

    }


}
