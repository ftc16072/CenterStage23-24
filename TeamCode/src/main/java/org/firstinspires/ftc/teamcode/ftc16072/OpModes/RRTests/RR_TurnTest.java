package org.firstinspires.ftc.teamcode.ftc16072.OpModes.RRTests;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.ftc16072.Robot;


@Autonomous(group = "RR")
public class RR_TurnTest extends OpMode {
    public static int TURN_ANGLE_DEGREES = 90;
    Robot robot = new Robot();

    private enum State {BEGIN, TURNING, DONE}

    State state = State.BEGIN;

    @Override
    public void init() {
        robot.makeDriveOnly();
        robot.init(hardwareMap);
    }

    @Override
    public void loop() {
        robot.nav.updatePoseEstimate();
        Pose2d currentPose = robot.nav.getPoseEstimate();

        telemetry.addData("STATE", state);
        telemetry.addData("POSE", "x = %.2f y = %.2f h = %.1f", currentPose.getX(), currentPose.getY(), Math.toDegrees(currentPose.getHeading()));
        switch (state) {
            case BEGIN:
                state = State.TURNING;
                robot.nav.turnAsync(Math.toRadians(TURN_ANGLE_DEGREES));
                break;
            case TURNING:
                robot.nav.update();
                if (!robot.nav.isBusy()){
                    state = State.DONE;
                }
                break;
            case DONE:
                break;
        }
    }
}
