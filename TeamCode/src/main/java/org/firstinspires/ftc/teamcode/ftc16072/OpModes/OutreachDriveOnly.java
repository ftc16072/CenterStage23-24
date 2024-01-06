package org.firstinspires.ftc.teamcode.ftc16072.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp()
public class OutreachDriveOnly extends QQOpMode {
    public static double OUTREACH_SPEED = .2;
    public static final double OUTREACH_TURBO_SPEED = .75;
    public static final double MAX_SPEED = 1.0;
    public static final double TRIGGER_THRESHOLD = 0.2;


    @Override
    public void init() {
        robot.makeDriveOnly();
        super.init();
    }

    @Override
    public void loop() {
        double speed_multiplier = OUTREACH_SPEED;
        if (gamepad1.right_trigger > TRIGGER_THRESHOLD) {
            speed_multiplier = OUTREACH_TURBO_SPEED;

        }
        if (gamepad1.right_bumper && gamepad1.left_bumper) {
            speed_multiplier = MAX_SPEED;
        }
        if (gamepad2.a) {
            robot.nav.fieldRelative(speed_multiplier * 0, speed_multiplier * 0, speed_multiplier * 0);
        } else {


            robot.nav.fieldRelative(speed_multiplier * -gamepad1.left_stick_y,
                    speed_multiplier * gamepad1.left_stick_x,
                    speed_multiplier * gamepad1.right_stick_x);
        }
    }
}
