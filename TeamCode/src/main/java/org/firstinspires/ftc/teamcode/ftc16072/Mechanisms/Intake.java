package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.qualcomm.robotcore.hardware.ColorRangeSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestMotor;

import java.util.Arrays;
import java.util.List;

public class Intake implements Mechanism{

    private DcMotor intakeMotor;
    private ColorRangeSensor pixelCounter;

    @Override
    public void init(HardwareMap hwMap) {
        intakeMotor = hwMap.get(DcMotor.class, "Intake_Motor");
        intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


    }

    public List<QQtest> getTests() {
        return Arrays.asList(
                new TestMotor("Intake Left", 0.2, intakeMotor));
    }


}
