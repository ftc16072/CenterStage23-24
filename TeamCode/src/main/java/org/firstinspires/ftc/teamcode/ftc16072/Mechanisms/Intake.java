package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestMotor;

import java.util.Arrays;
import java.util.List;

public class Intake implements Mechanism{
    public static final double Intake_Speed = 0.3;
    public static final double Eject_Speed = -0.5;
    private DcMotor intakeLeft;
 private DcMotor intakeRight;
    @Override
    public void init(HardwareMap hwMap) {
        intakeRight = hwMap.get(DcMotor.class, "Intake_Right");
        intakeLeft = hwMap.get(DcMotor.class, "Intake_Left");
        intakeRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intakeLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intakeLeft.setDirection(DcMotorSimple.Direction.REVERSE);

    }
    public void run(){
        intakeRight.setPower(Intake_Speed);
        intakeLeft.setPower(Intake_Speed);
    }
    public void stop(){
        intakeRight.setPower(0);
        intakeLeft.setPower(0);
    }
    public void eject(){
        intakeRight.setPower(Eject_Speed);
        intakeLeft.setPower(Eject_Speed);
    }

    @Override
    public List<QQtest> getTests() {
        return Arrays.asList(
                new TestMotor("Intake Right", 0.2, intakeRight),
                new TestMotor("Intake Left", 0.2, intakeLeft));
    }


}
