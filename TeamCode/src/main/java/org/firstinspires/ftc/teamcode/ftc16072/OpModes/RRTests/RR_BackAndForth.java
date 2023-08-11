package org.firstinspires.ftc.teamcode.ftc16072.OpModes.RRTests;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.ftc16072.Actions.DelayAction;
import org.firstinspires.ftc.teamcode.ftc16072.Robot;

@Config
@Autonomous(group = "RR")
public class RR_BackAndForth extends OpMode {

    Robot robot = new Robot();

    private enum State {BEGIN, AWAY, RETURN}

    State state = State.BEGIN;

    Trajectory trajectory;

    @Override
    public void init() {
        robot.makeDriveOnly();
        robot.init(hardwareMap);
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
                        .forward(48)
                        .build();
                robot.nav.follower.followTrajectory(trajectory);
                break;
            case AWAY:
                if (robot.nav.isDoneFollowing(currentPose)) {
                    new DelayAction(2);
                    state = State.RETURN;
                    trajectory = robot.nav.trajectoryBuilder(currentPose, true)
                            .back(48)
                            .build();
                    robot.nav.follower.followTrajectory(trajectory);
                }
                break;
            case RETURN:
                if (robot.nav.isDoneFollowing(currentPose)) {
                    state = State.BEGIN;
                }
                break;
        }
    }
}
