package org.firstinspires.ftc.teamcode.ftc16072.OpModes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.acmerobotics.roadrunner.util.NanoClock;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.ftc16072.Robot;

@Autonomous
public class MiddleSpikeToBackboard extends OpMode {
    Robot robot = new Robot();
    Trajectory trajectory;
    private enum State {BEGIN, AWAY, PAUSE, RETURN, DONE}
    State state = State.BEGIN;
    NanoClock clock;
    double startPause;
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

        //Trajectory to middle tape
        Trajectory leftSpikeTrajectory = robot.nav.trajectoryBuilder(currentPose, false)
                .back(25)
                .strafeRight(25)
                .build();

        Trajectory trajectory2 = robot.nav.trajectoryBuilder(trajectory1.end(), false)
                .strafeRight(25)
                .build();

        telemetry.addData("STATE", state);
        telemetry.addData("POSE", "x = %.2f y = %.2f h = %.1f", currentPose.getX(), currentPose.getY(), Math.toDegrees(currentPose.getHeading()));
        switch (state) {
            case BEGIN:
                state = State.AWAY;

                robot.nav.setPoseEstimate(currentPose);
                robot.nav.follower.followTrajectory(trajectory1);
                break;
            case AWAY:
                if (robot.nav.isDoneFollowing(currentPose)) {
                    state = State.PAUSE;
                    startPause = clock.seconds();
                }
                break;
            case PAUSE:
                if ((clock.seconds() - startPause) > 2.0) {

                    state = State.RETURN;

                }
                break;
            case RETURN:
                robot.nav.setPoseEstimate(trajectory1.end());
                robot.nav.follower.followTrajectory(trajectory2);

                break;
            case DONE:
                if (robot.nav.isDoneFollowing(currentPose)) {
                    state = State.DONE;
                }
                break;
        }


    }
}