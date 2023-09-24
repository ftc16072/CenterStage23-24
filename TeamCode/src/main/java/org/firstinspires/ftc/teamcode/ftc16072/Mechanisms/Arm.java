package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestServo;

import java.util.Arrays;
import java.util.List;

@Config
public class Arm implements Mechanism{
    public static double WRIST_INTAKE_POS = 0.0;
    public static double WRIST_PLACING_POS = 0.8;
    public static double WRIST_DRIVING_POS = 0.2;
    public static double WRIST_TESTING_POS = 0.2;
    public static double ARM_INTAKE_POS = 0.8;
    public static double ARM_PLACING_POS = 0.0;
    public static double ARM_DRIVING_POS = 0.7;
    public static double ARM_TESTING_POS = 0.2;
    public static double MAX_ARM_CHANGE = 0.02;

    double desiredArmPosition = ARM_DRIVING_POS;
    Servo armServo;
    Servo wristServo;

    @Override
    public void init(HardwareMap hwMap) {
        armServo = hwMap.get(Servo.class, "arm");
        wristServo = hwMap.get(Servo.class, "wrist");
    }
    public double findWristLocation(){return  wristServo.getPosition();}
    public double findArmLocation(){return armServo.getPosition();}

    public void setWristIntakePos(){wristServo.setPosition(WRIST_INTAKE_POS);}
    public void setWristPlacingPos(){wristServo.setPosition(WRIST_PLACING_POS);}
    public void setWristDrivingPos(){wristServo.setPosition(WRIST_DRIVING_POS);}
    public void setArmPlacingPos(){desiredArmPosition = ARM_PLACING_POS;}
    public void setArmIntakePos(){desiredArmPosition = ARM_INTAKE_POS;}
    public void setArmDrivingPos(){desiredArmPosition = ARM_DRIVING_POS;}
    public void goToPlacingPos(){setArmPlacingPos(); setWristPlacingPos();}
    public void goToIntakePos(){setArmIntakePos();setWristIntakePos();}
    public void goToDrivingPos(){setArmDrivingPos();setWristDrivingPos();}

    public void update(Telemetry telemetry){
        double armServoPosition = armServo.getPosition();

        wristServo.setPosition(getDesiredWristPosition(armServoPosition));

        double changeAmount = desiredArmPosition - armServoPosition;

        changeAmount = Math.min(MAX_ARM_CHANGE, Math.abs(changeAmount)) * Math.signum(changeAmount);

        armServo.setPosition(armServoPosition + changeAmount);

        telemetry.addData("Desired Pos", desiredArmPosition);
        telemetry.addData("Actual Pos", armServoPosition);
    }

    public double getDesiredWristPosition(double armTicks){
        double wristRange = WRIST_PLACING_POS - WRIST_INTAKE_POS;
        double armRange  = ARM_PLACING_POS - ARM_INTAKE_POS;

        double armOffset = armTicks - ARM_INTAKE_POS;
        double wristOffset = armOffset * (wristRange / armRange);

        double wristPos = wristOffset + WRIST_INTAKE_POS;
        if(wristPos < WRIST_INTAKE_POS){
            return WRIST_INTAKE_POS;
        }else if (wristPos > WRIST_PLACING_POS){
            return WRIST_PLACING_POS;
        }
        return wristPos;
    }

    @Override
    public List<QQtest> getTests() {
        return Arrays.asList(
                new TestServo("Arm", ARM_TESTING_POS, ARM_INTAKE_POS, armServo),
                new TestServo("Wrist", WRIST_TESTING_POS, WRIST_INTAKE_POS, wristServo));
    }
}
