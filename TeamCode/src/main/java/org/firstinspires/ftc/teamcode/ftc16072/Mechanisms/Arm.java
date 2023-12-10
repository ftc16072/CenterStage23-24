package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestServo;

import java.util.Arrays;
import java.util.List;

public class Arm implements Mechanism{

    private static final double INTAKE_ARM_POS = 89328;
    private static final double PLACING_ARM_POS = 9283;

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
        armPosition= ArmPositions.INTAKE_POSITION;

    }

    @Override
    public List<QQtest> getTests() {
        return Arrays.asList(
                new TestServo("left_arm_servo", 0.25, 0, leftArmServo),
                new TestServo("right_arm_servo", -0.25,0, rightArmServo)
        );
    }
    public void goToIntakePosition(){
        leftArmServo.setPosition(INTAKE_ARM_POS);
        rightArmServo.setPosition(-INTAKE_ARM_POS);
        armPosition= ArmPositions.INTAKE_POSITION;
    }
    public void goToPlacingPosition(){
        leftArmServo.setPosition(PLACING_ARM_POS);
        rightArmServo.setPosition(-PLACING_ARM_POS);
        armPosition= ArmPositions.PLACING_POSITION;
    }
    public ArmPositions getArmPosition(){
        return armPosition;
    }
}

