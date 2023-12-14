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

    public static final int INTAKE_SPEED = 1;
    public static final int EJECT_SPEED = -1;
    private DcMotor intakeMotor;
    @Override
    public void init(HardwareMap hwMap) {
        intakeMotor = hwMap.get(DcMotor.class, "Intake_Motor");
        intakeMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public List<QQtest> getTests() {
        return Arrays.asList(
                new TestMotor("Intake", 0.6, intakeMotor),
                new TestMotor("Eject", -0.6, intakeMotor));

    }
    public void intake(){
        intakeMotor.setPower(INTAKE_SPEED);
    }
    public void eject(){
        intakeMotor.setPower(EJECT_SPEED);
    }
    public void stop(){
        intakeMotor.setPower(0);
    }

}
