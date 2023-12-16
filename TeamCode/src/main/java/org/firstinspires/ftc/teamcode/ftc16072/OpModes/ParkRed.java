package org.firstinspires.ftc.teamcode.ftc16072.OpModes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.State;
import org.firstinspires.ftc.teamcode.ftc16072.Robot;
@TeleOp
public class ParkRed extends OpMode {
    Robot robot = new Robot();
    Trajectory trajectory;
    private enum State {BEGIN, MOVING, DONE}
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
                state = State.MOVING;
                trajectory = robot.nav.trajectoryBuilder(currentPose, false)
                        .strafeRight(29)
                        .build();

                robot.nav.follower.followTrajectory(trajectory);
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
