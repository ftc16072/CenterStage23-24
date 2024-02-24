package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestMotor;

import java.util.Arrays;
import java.util.List;

@Config
public class Climber implements Mechanism {
    private DcMotor climberMotor;
    public static double SPEED_CLIMB = 1;
    static double TEST_SPEED = 0.5;

    @Override
    public void init(HardwareMap hwMap) {
        climberMotor = hwMap.get(DcMotor.class, "climber_motor");
    }

    public List<QQtest> getTests() {
        return Arrays.asList(
                new TestMotor("climber lower", TEST_SPEED, climberMotor),
                new TestMotor("climber release", -TEST_SPEED, climberMotor));

    }

    public void down() {
        climberMotor.setPower(SPEED_CLIMB);
    }

    public void up() {
        climberMotor.setPower(-SPEED_CLIMB);
    }

    public void stop() {
        climberMotor.setPower(0);
    }
}



