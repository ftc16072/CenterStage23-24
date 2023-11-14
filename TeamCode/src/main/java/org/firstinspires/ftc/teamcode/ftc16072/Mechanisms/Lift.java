package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestTwoMotor;

import java.util.Collections;
import java.util.List;

public class Lift implements  Mechanism{
    private DcMotorEx rightLiftMotor;
    private DcMotorEx leftLiftMotor;

    private int desiredPosition;
    private int sumOfErrors;
    private int lastError;
    static double K_P = 0.001;
    static double K_I = 0.0001;
    static double K_D = 0.2;

    @Override
    public void init(HardwareMap hwMap) {
        rightLiftMotor = hwMap.get(DcMotorEx.class, "right_lift_motor");
        rightLiftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rightLiftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightLiftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftLiftMotor = hwMap.get(DcMotorEx.class, "left_lift_motor");
        leftLiftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftLiftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    private void setDesiredPosition(int newPosition){
        desiredPosition = newPosition;
        sumOfErrors = 0;
        lastError = 0;
    }
    public void update(){
        int error;
        error = desiredPosition - rightLiftMotor.getCurrentPosition();
        sumOfErrors = sumOfErrors + error;

        double motorPower =K_P * error + K_I * sumOfErrors + K_D * (error - lastError);
        lastError = error;

        rightLiftMotor.setPower(motorPower);
        leftLiftMotor.setPower(motorPower);
    }

    @Override
    public List<QQtest> getTests() {
        return Collections.singletonList(
                new TestTwoMotor("lift", leftLiftMotor, rightLiftMotor, 0.5)
        );
    }
}
