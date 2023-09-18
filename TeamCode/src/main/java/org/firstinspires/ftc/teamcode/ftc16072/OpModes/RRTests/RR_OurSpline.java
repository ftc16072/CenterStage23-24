package org.firstinspires.ftc.teamcode.ftc16072.OpModes.RRTests;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.acmerobotics.roadrunner.util.NanoClock;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.ftc16072.Robot;

@Disabled
@Autonomous(group = "RR")
public class RR_OurSpline extends OpMode {

    Robot robot = new Robot();

    private enum State {BEGIN, AWAY, PAUSE, RETURN, DONE}

    State state = State.BEGIN;

    NanoClock clock;
    double startPause;

    Trajectory trajectory;

    @Override
    public void init() {
        robot.makeDriveOnly();
        robot.init(hardwareMap);
        clock = NanoClock.system();
    }

    @Override
    public void loop() {
        robot.nav.updatePoseEstimate();
        Pose2d currentPose = robot.nav.getPoseEstimate();

        telemetry.addData("STATE", state);
        telemetry.addData("POSE", "x = %.2f y = %.2f h = %.1f", currentPose.getX(), currentPose.getY(), Math.toDegrees(currentPose.getHeading()));
        switch (state) {
            case BEGIN:
                state = State.AWAY;
                trajectory = robot.nav.trajectoryBuilder(new Pose2d(-36.69, -70.87, Math.toRadians(90)), false)
                        .splineTo(new Vector2d(-36.48,-24.27), Math.toRadians(90.39))
                        .splineTo(new Vector2d(9.80,-8.68), Math.toRadians(18.61))
                        .splineTo(new Vector2d(10.61,11.73), Math.toRadians(87.75))
//                        .splineTo(new Vector2d(-15.96,-14.82), Math.toRadians(90.73))
//                        .splineTo(new Vector2d(-5.75,-12.39), Math.toRadians(-5.25))
//                        .splineTo(new Vector2d(8.34,-12.39), Math.toRadians(5.71))
//                        .splineTo(new Vector2d(12.72, 11.42), Math.toRadians(79.59))
                        .build();
                robot.nav.setPoseEstimate(trajectory.start());
                robot.nav.follower.followTrajectory(trajectory);
                break;
            case AWAY:
                if (robot.nav.isDoneFollowing(currentPose)) {
                    state = State.DONE;
                    startPause = clock.seconds();
                }
                break;
            case PAUSE:
                if ((clock.seconds() - startPause) > 2.0) {
                    state = State.RETURN;
                    trajectory = robot.nav.trajectoryBuilder(currentPose, true)
                            .splineTo(new Vector2d(0, 0), Math.toRadians(180))
                            .build();
                    robot.nav.follower.followTrajectory(trajectory);
                }
                break;
            case RETURN:
                if (robot.nav.isDoneFollowing(currentPose)) {
                    state = State.DONE;
                }
                break;
            case DONE:
                break;
        }
    }
}
