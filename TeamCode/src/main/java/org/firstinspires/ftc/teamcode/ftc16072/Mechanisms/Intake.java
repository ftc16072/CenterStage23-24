package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestMotor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Intake implements Mechanism{

    public static final double INTAKE_SPEED = -0.7;
    public static final double EJECT_SPEED = 0.5;
    private DcMotor intakeMotor;
    @Override
    public void init(HardwareMap hwMap) {
        intakeMotor = hwMap.get(DcMotor.class, "Intake_Motor");
        intakeMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public List<QQtest> getTests() {
        return Arrays.asList(
                new TestMotor("Intake", INTAKE_SPEED, intakeMotor),
                new TestMotor("Eject", EJECT_SPEED, intakeMotor));

    }
    public void intake(double amount){
        intakeMotor.setPower(INTAKE_SPEED * amount);
    }
    public void eject(){
        intakeMotor.setPower(EJECT_SPEED);
    }
    public void stop(){
        intakeMotor.setPower(0);
    }

}
