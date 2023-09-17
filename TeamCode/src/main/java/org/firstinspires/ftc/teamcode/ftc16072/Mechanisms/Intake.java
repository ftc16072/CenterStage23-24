package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestMotor;

import java.util.Arrays;
import java.util.List;

public class Intake implements Mechanism{
 private DcMotor intakeLeft;
 private DcMotor intakeRight;
    @Override
    public void init(HardwareMap hwMap) {
        intakeRight = hwMap.get(DcMotor.class, "Intake_Right");
        intakeLeft = hwMap.get(DcMotor.class, "Intake_Left");
        intakeRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intakeLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }
    public void Run_intake(){
        intakeRight.setPower(1.0);
        intakeLeft.setPower(-1.0);
    }
    public void Stop_intake(){
        intakeRight.setPower(0);
        intakeLeft.setPower(0);
    }
    public void Eject_intake(){
        intakeRight.setPower(-0.5);
        intakeLeft.setPower(0.5);
    }

    @Override
    public List<QQtest> getTests() {
        return Arrays.asList(
                new TestMotor("Intake Right", 0.2, intakeRight),
                new TestMotor("Intake Left", 0.2, intakeLeft));
    }


}
