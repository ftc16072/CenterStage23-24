package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestTwoMotor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lift implements  Mechanism{
    public enum LiftPositions{
        FLOOR_POSITION,
        LOW_POSITION,
        MIDDLE_POSITION,
        TOP_POSITION

    }
    public static final int ARE_SLIDES_EXTENDED_BOUNDARY = 100; //TODO tune value

    public LiftPositions manipulatorPosition;
    private static final double LIFT_POSITION_SAFETY_BOTTOM = 392749;
    private static final double LOW_POSITION = 3923749;
    private static final double MIDDLE_POSITION = 47832;
    private static final double TOP_POSITION = 822727;
    private static final double FLOOR_POSITION =898998  ;
    private static final double PIXEL_HEIGHT = 271;
    private final double MANUAL_CHANGE = 100;
    private DcMotorEx rightLiftMotor;
    private DcMotorEx leftLiftMotor;




    public  double desiredPosition;
    private double sumOfErrors;
    private double lastError;
    static double K_P = 0.001;
    static double K_I = 0.0001;
    static double K_D = 0.2;

    private static final int LIFT_POSITION_SAFETY_TOP = 343455; //TODO need to fix

    @Override
    public void init(HardwareMap hwMap) {
        rightLiftMotor = hwMap.get(DcMotorEx.class, "right_lift_motor");
        rightLiftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rightLiftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightLiftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftLiftMotor = hwMap.get(DcMotorEx.class, "left_lift_motor");
        leftLiftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftLiftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        manipulatorPosition = LiftPositions.FLOOR_POSITION;


    }
    private void setDesiredPosition(int newPosition){
        desiredPosition = newPosition;
        sumOfErrors = 0;
        lastError = 0;
    }
    public boolean areSlidesExtendedPastBoundary(){
        return   currentPosition()> ARE_SLIDES_EXTENDED_BOUNDARY;

        }
    public void update(){
        double error;
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
    public void manualLiftUp(){
        desiredPosition = currentPosition() + MANUAL_CHANGE;
        if(desiredPosition > LIFT_POSITION_SAFETY_TOP){
            desiredPosition = LIFT_POSITION_SAFETY_TOP;
        }
    }public void manualLiftDown(){
        desiredPosition = currentPosition()-MANUAL_CHANGE;
        if(desiredPosition < LIFT_POSITION_SAFETY_BOTTOM){
            desiredPosition = LIFT_POSITION_SAFETY_BOTTOM;

        }
    }
    public void goToLow(){
        desiredPosition = LOW_POSITION;
    }
    public void goToMiddle(){
        desiredPosition = MIDDLE_POSITION;
    }
    public void goToTop(){
        desiredPosition = TOP_POSITION;
    }
    public void goToFloor(){
        desiredPosition = FLOOR_POSITION;
    }
    public void upOnePixel(){
        desiredPosition = currentPosition() + PIXEL_HEIGHT;
    }
    public void downOnePixel(){
        desiredPosition = currentPosition() - PIXEL_HEIGHT;
    }
    public double currentPosition(){
        return (rightLiftMotor.getCurrentPosition() + leftLiftMotor.getCurrentPosition())/2.0;
    }
}
