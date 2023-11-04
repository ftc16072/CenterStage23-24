package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestSwitch;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestTwoMotor;

import java.util.Arrays;
import java.util.List;

public class Lift implements  Mechanism{
    private DcMotorEx rightLiftMotor;
    private DcMotorEx leftLiftMotor;

    private DigitalChannel liftLimitSwitch;
    @Override
    public void init(HardwareMap hwMap) {
        leftLiftMotor = hwMap.get(DcMotorEx.class, "left_lift_motor");
        rightLiftMotor = hwMap.get(DcMotorEx.class, "right_lift_motor");
        liftLimitSwitch = hwMap.get(DigitalChannel.class,"lift_limit_switch");
        rightLiftMotor.setDirection(DcMotorSimple.Direction.REVERSE);


    }

    @Override
    public List<QQtest> getTests() {
        return Arrays.asList(
                new TestTwoMotor("lift",leftLiftMotor,rightLiftMotor,0.5),
                new TestSwitch("lift limit switch",liftLimitSwitch)

        );
    }
}
