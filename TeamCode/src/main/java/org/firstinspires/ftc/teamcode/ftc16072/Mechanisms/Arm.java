package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestMotor;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestServo;

import java.util.Arrays;
import java.util.List;

@Config
public class Arm implements Mechanism{
    static final double TICKS_PER_REV = 751.8; // From GoBilda for a 223 RPM
    public static double WRIST_INTAKE_POS = 0.0;
    public static double WRIST_PLACING_POS = 1.0;
    public static int ARM_INTAKE_POS = 0;
    public static int ARM_PLACING_ANGLE = 120;
    public static double K_P = 0.01;
    public static double K_I = 0;
    public static double K_D = 0.2;
    public static double K_F = 0.1;
    public static double MAX_ARM_SPEED = 0.25;
    public static int TOLERANCE_TICKS = 20;

    public static double ARM_TICKS =
            TICKS_PER_REV * ((double)ARM_PLACING_ANGLE / 360);
    public static int ARM_PLACING_POS = (int) ARM_TICKS;

    int desiredArmPosition;
    DcMotorEx arm;
    Servo wrist;
    ElapsedTime timer = new ElapsedTime();
    @Override
    public void init(HardwareMap hwMap) {
        arm = hwMap.get(DcMotorEx.class, "arm");
        wrist = hwMap.get(Servo.class, "wrist");
        arm.setDirection(DcMotorSimple.Direction.REVERSE);
        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void findServoLocation(){
        wrist.setPosition(WRIST_INTAKE_POS);
    }

    public void goToPlacementPos(){
        desiredArmPosition = ARM_PLACING_POS;
        timer.reset();
    }

    public void goToIntakePos(){
        desiredArmPosition = ARM_INTAKE_POS;
        timer.reset();
    }

    int lastError = 0;
    double integralSum = 0;
    public void update(Telemetry telemetry){
        int armTicks = arm.getCurrentPosition();
        //getDesiredWristPosition(armTicks, telemetry);
        wrist.setPosition(getDesiredWristPosition(armTicks, telemetry));

        int error = desiredArmPosition - armTicks;
        double derivative = (error - lastError) * timer.seconds();
        integralSum = integralSum + (error * timer.seconds());
        if(integralSum > 1){
            integralSum = 1;
        }
        else if(integralSum < -1){
            integralSum = -1;
        }

        double power = error * K_P + integralSum * K_I + derivative * K_D + K_F;
        lastError = error;
        timer.reset();

        if(Math.abs(error) < TOLERANCE_TICKS){
            power = 0;
        }
        power = Math.min(MAX_ARM_SPEED, Math.abs(power)) * Math.signum(power);
        arm.setPower(power);
        telemetry.addData("Arm power", power);
        telemetry.addData("Desired Pos", desiredArmPosition);
        telemetry.addData("Actual Pos", armTicks);
    }

    public double getDesiredWristPosition(int armTicks, Telemetry telemetry){
        double wristRange = WRIST_PLACING_POS - WRIST_INTAKE_POS;
        int armRange  = ARM_PLACING_POS - ARM_INTAKE_POS;

        int armOffset = armTicks - ARM_INTAKE_POS;
        double wristOffset = armOffset * (wristRange / armRange);
        telemetry.addData("Arm ticks", armTicks);
        telemetry.addData("Arm Offset", armOffset);
        telemetry.addData("Wrist Offset", wristOffset);
        telemetry.addData("Wrist Pos", wristOffset + WRIST_INTAKE_POS);

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
                new TestMotor("Arm", 0.2, arm),
                new TestServo("Wrist", 0, 0.5, wrist));
    }
}
