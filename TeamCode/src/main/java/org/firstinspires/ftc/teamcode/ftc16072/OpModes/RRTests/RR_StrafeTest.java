package org.firstinspires.ftc.teamcode.ftc16072.OpModes.RRTests;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.acmerobotics.roadrunner.util.NanoClock;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.ftc16072.Robot;


@Autonomous(group = "RR")
public class RR_StrafeTest extends OpMode {

    Robot robot = new Robot();

    private enum State {BEGIN, AWAY, DONE}

    State state = State.BEGIN;

    NanoClock clock;
    double startPause;

    Trajectory trajectory;

    @Override
    public void init() {
        robot.makeDriveOnly();
        robot.init(hardwareMap);
        clock = NanoClock.system();
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
        telemetry.addData("x", 0);
        telemetry.addData("y", 0);
        telemetry.addData("desired y", 48);
    }


    @Override
    public void loop() {
        robot.nav.updatePoseEstimate();
        Pose2d currentPose = robot.nav.getPoseEstimate();
        telemetry.addData("x", currentPose.getX());
        telemetry.addData("y", currentPose.getY());
        telemetry.addData("desired y", 48);




        telemetry.addData("STATE", state);
        telemetry.addData("POSE", "x = %.2f y = %.2f h = %.1f", currentPose.getX(), currentPose.getY(), Math.toDegrees(currentPose.getHeading()));
        switch (state) {
            case BEGIN:
                state = State.AWAY;
                trajectory = robot.nav.trajectoryBuilder(currentPose, false)
                        .strafeLeft(48)
                        .build();
                robot.nav.follower.followTrajectory(trajectory);
                break;
            case AWAY:
                if (robot.nav.isDoneFollowing(currentPose)) {
                    state = State.DONE;
                    startPause = clock.seconds();
                }
                break;
            case DONE:
                break;
        }
    }
}
