package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestMotor;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestTwoMotor;

import java.util.Arrays;
import java.util.List;
@Config
public class Lift implements  Mechanism{
    public LiftPositions getManipulatorPosition() {
        return manipulatorPosition;
    }

    public void setManipulatorPosition(LiftPositions manipulatorPosition) {
        this.manipulatorPosition = manipulatorPosition;
    }






    public enum LiftPositions{
        FLOOR_POSITION,
        LOW_POSITION,
        MIDDLE_POSITION,
        TOP_POSITION

    }
    public static final int ARE_SLIDES_EXTENDED_BOUNDARY = 800;

    private LiftPositions manipulatorPosition;
    private static final int LIFT_POSITION_SAFETY_BOTTOM = -50;
    private static final int LIFT_POSITION_SAFETY_TOP = 2600; //TODO: find actual

    private static final int PIXEL_GRAB_POSITION=0;

    private static final int LOW_POSITION = 700;
    private static final int MIDDLE_POSITION = 1600;
    private static final int TOP_POSITION = 2400;
    private static final int INTAKE_POSITION = 100;
    private static final int FLOOR_POSITION =0  ;
    private static final int PIXEL_HEIGHT = 271;
    private final int MANUAL_CHANGE = 50;
    private DcMotorEx rightLiftMotor;
    private DcMotorEx leftLiftMotor;




    private double desiredPosition;
    private double sumOfErrors;
    private double lastError;
    public static double K_P = 0.002;
    public static double K_I = 0;
    public static double K_D = 0;


    @Override
    public void init(HardwareMap hwMap) {
        rightLiftMotor = hwMap.get(DcMotorEx.class, "right_lift_motor");
        rightLiftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rightLiftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightLiftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightLiftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftLiftMotor = hwMap.get(DcMotorEx.class, "left_lift_motor");
        leftLiftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftLiftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftLiftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        setManipulatorPosition(LiftPositions.FLOOR_POSITION);
        desiredPosition = leftLiftMotor.getCurrentPosition();



    }
    private void setDesiredPosition(double newPosition){
        if(newPosition > LIFT_POSITION_SAFETY_TOP){
            newPosition = LIFT_POSITION_SAFETY_TOP;
        }
        if(newPosition < LIFT_POSITION_SAFETY_BOTTOM){
            newPosition = LIFT_POSITION_SAFETY_BOTTOM;
        }

        desiredPosition = newPosition;
        sumOfErrors = 0;
        lastError = 0;
    }

    public boolean areSlidesExtendedPastBoundary(){
        return currentPosition()> ARE_SLIDES_EXTENDED_BOUNDARY;

        }
    public void update(Telemetry telemetry){
        double motorPower;
        double error;
        error = getDesiredPosition() - currentPosition();
        telemetry.addData("Desired Pos", getDesiredPosition());
        telemetry.addData("Curr Pos", currentPosition());

        sumOfErrors = sumOfErrors + error;

        motorPower =K_P * error + K_I * sumOfErrors + K_D * (error - lastError);

        lastError = error;
        telemetry.addData("error", error);

        /*
        if (Math.abs(motorPower) < 0.1){
            motorPower = 0;
        }
        */

        telemetry.addData("lift power: ",motorPower);

        rightLiftMotor.setPower(motorPower);
        leftLiftMotor.setPower(motorPower);
    }

    @Override
    public List<QQtest> getTests() {
        return Arrays.asList(
                new TestTwoMotor("lift", leftLiftMotor, rightLiftMotor, 0.5),
                new TestTwoMotor("downLift", leftLiftMotor, rightLiftMotor, -0.5),
                new TestMotor("right lift motor", 0.5, rightLiftMotor),
                new TestMotor("left lift motor", 0.5, leftLiftMotor)
                );
    }

    public void manualLiftUp(){
        setDesiredPosition(getDesiredPosition() + MANUAL_CHANGE);
    }
    public void manualLiftDown(){
        setDesiredPosition(getDesiredPosition() - MANUAL_CHANGE);
    }
    public double getDesiredPosition(){
        return desiredPosition;
    }
    public void goToPixelGrab(){
        setDesiredPosition(PIXEL_GRAB_POSITION);
    }
    public void goToIntake(){
        setDesiredPosition(INTAKE_POSITION);
    }

    public void goToLow(){
        setDesiredPosition(LOW_POSITION);
    }
    public void goToMiddle(){
        setDesiredPosition(MIDDLE_POSITION);
    }
    public void goToTop(){
        setDesiredPosition(TOP_POSITION);
    }
    public void goToFloor(){
        setDesiredPosition(FLOOR_POSITION);
    }
    public void upOnePixel(){
        setDesiredPosition(currentPosition() + PIXEL_HEIGHT);
    }
    public void downOnePixel(){
        setDesiredPosition(currentPosition() - PIXEL_HEIGHT);
    }
    public double currentPosition(){
        return ((rightLiftMotor.getCurrentPosition() + leftLiftMotor.getCurrentPosition())/2.0);
    }

}
