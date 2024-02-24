package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestMotor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Config
public class MecanumDrive implements Mechanism {
    public static final double FAST_DRIVE_MULTIPLIER = 1.0;
    public boolean doSlowDrive = false;
    public final double SLOW_DRIVE_MULTIPLIER = 0.4;
    public final double REGULAR_DRIVE_MULTIPLIER = 0.6;
    DcMotor backLeftMotor;
    DcMotor backRightMotor;
    DcMotor frontRightMotor;
    DcMotor frontLeftMotor;
    private double frontLeftPower;
    private double frontRightPower;
    private double backLeftPower;
    private double backRightPower;

    public static final double SECS_PER_MIN = 60.0;
    public static final double MM_PER_IN = 25.4;

    // depending on drive motor
    public static final double TICKS_PER_REV = 384.5; // for gobilda 5203 312 rpm motors
    public static final double MAX_RPM = 435;
    public static final double WHEEL_DIAM_IN = 96 / MM_PER_IN;
    public static double TRACK_WIDTH_IN = 16.65;  // from TrackWidthTuner
    public static final double MAX_MOTOR_VELOCITY = MAX_RPM * Math.PI * WHEEL_DIAM_IN / SECS_PER_MIN;

    public static double MAX_VELOCITY = 30;
    public static double MAX_ACCELERATION = 60;
    public static double MAX_ANGULAR_VELOCITY = Math.PI;
    public static double MAX_ANGULAR_ACCELERATION = Math.PI;

    private double speedMultiplier = 1.0;

    //Roadrunner tuning values
    //public static final double LATERAL_MULTIPLIER = 0.92717643;


    public void init(HardwareMap HwMap) {
        backLeftMotor = HwMap.get(DcMotor.class, "back_left_motor");
        backRightMotor = HwMap.get(DcMotor.class, "back_right_motor");
        frontRightMotor = HwMap.get(DcMotor.class, "front_right_motor");
        frontLeftMotor = HwMap.get(DcMotor.class, "front_left_motor");

        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        List<DcMotor> motors = Arrays.asList(backLeftMotor, backRightMotor, frontRightMotor, frontLeftMotor);
        for (DcMotor motor : motors) {
            motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
    }

    @Override
    public List<QQtest> getTests() {
        return Arrays.asList(
                new TestMotor("Back Left", 0.2, backLeftMotor),
                new TestMotor("Back Right", 0.2, backRightMotor),
                new TestMotor("Front Left", 0.2, frontLeftMotor),
                new TestMotor("Front Right", 0.2, frontRightMotor));
    }

    @Override
    public String getName() {
        return "MecanumDrive";
    }

    public void setSlowDrive() {
        speedMultiplier = SLOW_DRIVE_MULTIPLIER;
    }

    public void setFastDrive() {
        speedMultiplier = FAST_DRIVE_MULTIPLIER;
    }

    public void setNormalDrive() {
        speedMultiplier = REGULAR_DRIVE_MULTIPLIER;
    }

    public void move(double forward, double right, double rotate) {
        double frontLeftPower = forward + right + rotate;
        double frontRightPower = forward - right - rotate;
        double backRightPower = forward + right - rotate;
        double backLeftPower = forward - right + rotate;

        setPowers(frontLeftPower, frontRightPower, backLeftPower, backRightPower);
    }

    public void setPowers(double frontLeftPower, double frontRightPower, double backLeftPower, double backRightPower) {

        frontLeftPower *= speedMultiplier;
        frontRightPower *= speedMultiplier;
        backLeftPower *= speedMultiplier;
        backRightPower *= speedMultiplier;


        double maxSpeed = 1.0;

        maxSpeed = Math.max(maxSpeed, Math.abs(frontLeftPower));
        maxSpeed = Math.max(maxSpeed, Math.abs(frontRightPower));
        maxSpeed = Math.max(maxSpeed, Math.abs(backLeftPower));
        maxSpeed = Math.max(maxSpeed, Math.abs(backRightPower));

        frontLeftPower /= maxSpeed;
        frontRightPower /= maxSpeed;
        backLeftPower /= maxSpeed;
        backRightPower /= maxSpeed;

        frontLeftMotor.setPower(frontLeftPower);
        frontRightMotor.setPower(frontRightPower);
        backLeftMotor.setPower(backLeftPower);
        backRightMotor.setPower(backRightPower);

    }

    public double getAverageDrivetrainPower() {
        return (frontLeftPower + frontRightPower + backLeftPower + backRightPower) / 4;

    }


    private double ticksToInches(double ticks) {
        return WHEEL_DIAM_IN * Math.PI * ticks / TICKS_PER_REV;
    }

    public List<Double> getWheelPositions() {
        List<Double> wheelPositions = new ArrayList<>();
        wheelPositions.add(ticksToInches(frontLeftMotor.getCurrentPosition()));
        wheelPositions.add(ticksToInches(backLeftMotor.getCurrentPosition()));
        wheelPositions.add(ticksToInches(backRightMotor.getCurrentPosition()));
        wheelPositions.add(ticksToInches(frontRightMotor.getCurrentPosition()));
        return wheelPositions;
    }


}
