package org.firstinspires.ftc.teamcode.ftc16072.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp()
//@Disabled
public class DriveOnly extends QQOpMode {

    @Override
    public void init() {
        robot.makeDriveOnly();
        super.init();
    }

    @Override
    public void loop() {
        robot.mecanumDrive.move(-gamepad1.left_stick_y,
                gamepad1.left_stick_x,
                gamepad1.right_stick_x);
    }
}
