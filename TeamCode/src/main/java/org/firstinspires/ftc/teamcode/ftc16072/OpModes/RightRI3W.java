package org.firstinspires.ftc.teamcode.ftc16072.OpModes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.acmerobotics.roadrunner.util.NanoClock;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.ftc16072.Robot;


@Autonomous()
public class RightRI3W extends OpMode {

    Robot robot = new Robot();

    public enum State {BEGIN, FORWARD, MOVING, DONE}

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
                state = State.FORWARD;
                trajectory = robot.nav.trajectoryBuilder(currentPose, false)
                        .strafeLeft(8)
                        .build();

                robot.nav.follower.followTrajectory(trajectory);
                break;
            case FORWARD:
                if (robot.nav.isDoneFollowing(currentPose)) {
                    trajectory = robot.nav.trajectoryBuilder(currentPose, false)
                            .forward(75)
                            .build();

                    robot.nav.follower.followTrajectory(trajectory);
                    state = State.MOVING;
                    startPause = clock.seconds();
                }
                break;
            case MOVING:
                if (robot.nav.isDoneFollowing(currentPose)) {
                    state = State.DONE;
                }
                break;


            case DONE:

                break;
        }
    }
}
