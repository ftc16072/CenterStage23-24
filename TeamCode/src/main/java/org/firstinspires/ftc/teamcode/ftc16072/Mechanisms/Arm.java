package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestServo;

import java.util.Arrays;
import java.util.List;

public class Arm implements Mechanism{

    private static final double RIGHT_SERVO_INTAKE_ARM_POS = 0;  //value not tested
    private static final double RIGHT_SERVO_PLACING_ARM_POS = 0.6;  //value not tested

    private static final double LEFT_SERVO_PLACING_ARM_POS = 0.6 ; //value not tested
    private static final double LEFT_SERVO_INTAKE_ARM_POS = 0; //value not tested

    public enum ArmPositions{
        PLACING_POSITION,
        INTAKE_POSITION
    }
    private Servo leftArmServo;
    private Servo rightArmServo;
    public ArmPositions armPosition;
    @Override
    public void init(HardwareMap hwMap) {
        leftArmServo = hwMap.get(Servo.class,"left_arm_servo");
        rightArmServo = hwMap.get(Servo.class,"right_arm_servo");
        rightArmServo.setDirection(Servo.Direction.REVERSE);
        //armPosition= ArmPositions.INTAKE_POSITION; // could be

    }

    @Override
    public List<QQtest> getTests() {
        return Arrays.asList(
                new TestServo("left_arm_servo", 1, 0, leftArmServo),
                new TestServo("right_arm_servo", 1,0, rightArmServo)
        );
    }
    public void goToIntakePosition(){
        leftArmServo.setPosition(LEFT_SERVO_INTAKE_ARM_POS);
        rightArmServo.setPosition(RIGHT_SERVO_INTAKE_ARM_POS);
        armPosition= ArmPositions.INTAKE_POSITION;
    }
    public void goToPlacingPosition(){
        leftArmServo.setPosition(LEFT_SERVO_PLACING_ARM_POS);
        rightArmServo.setPosition(RIGHT_SERVO_PLACING_ARM_POS);
        armPosition= ArmPositions.PLACING_POSITION;
    }
    public ArmPositions getArmPosition(){
        return armPosition;
    }
}

