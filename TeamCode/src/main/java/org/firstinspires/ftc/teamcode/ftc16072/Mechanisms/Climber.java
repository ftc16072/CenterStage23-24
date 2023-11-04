package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.usb.RobotArmingStateNotifier;

import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestMotor;

import java.util.Arrays;
import java.util.List;

public class Climber implements Mechanism{
    private DcMotor climberMotor;
    @Override
    public void init(HardwareMap hwMap) {
        climberMotor = hwMap.get(DcMotor.class,"climber_motor");
    }

    @Override
    public List<QQtest> getTests() {
        return Arrays.asList(
                new TestMotor("climber_motor",0.5,climberMotor)
        );
    }
}
