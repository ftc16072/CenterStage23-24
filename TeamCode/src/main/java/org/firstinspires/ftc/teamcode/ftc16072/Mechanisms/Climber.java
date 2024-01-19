package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestMotor;

import java.util.Arrays;
import java.util.List;

@Config
public class Climber implements Mechanism{
    private DcMotor climberMotor;
    public static double ClimbSpeed = 1;
    @Override
    public void init(HardwareMap hwMap) {
        climberMotor = hwMap.get(DcMotor.class,"climber_motor");
    }
    public List<QQtest> getTests() {
        return Arrays.asList(
                new TestMotor("climber_motor",0.5,climberMotor));

        }
        public void Climb() {
        climberMotor.setPower(ClimbSpeed);
    }




}



