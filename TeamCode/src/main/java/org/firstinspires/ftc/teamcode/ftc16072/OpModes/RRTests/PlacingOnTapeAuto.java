package org.firstinspires.ftc.teamcode.ftc16072.OpModes.RRTests;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.VisionBase;
import org.firstinspires.ftc.teamcode.ftc16072.Robot;
import org.firstinspires.ftc.teamcode.ftc16072.Util.TeamPropLocation;

@Autonomous
public class PlacingOnTapeAuto extends VisionBase {
    Robot robot = new Robot();
    Trajectory trajectory;
    private enum State {BEGIN, FORWARD,TURN,FORWARD_TO_TAPE, DONE}
    State state = State.BEGIN;
    @Override
    public void init() {
        robot.init(hardwareMap);
        super.init(); // for vision
    }
    public void init_loop(){

    }

    @Override
    public void loop() {
        robot.nav.updatePoseEstimate();
        Pose2d currentPose = robot.nav.getPoseEstimate();
        TeamPropLocation teamPropLocation = robot.cameraBack.getTeamPropPosition();

        telemetry.addData("team prop", teamPropLocation);
        telemetry.addData("POSE", "x = %.2f y = %.2f h = %.1f", currentPose.getX(), currentPose.getY(), Math.toDegrees(currentPose.getHeading()));
        switch (state) {
            case BEGIN:
                state = State.FORWARD;
                if (teamPropLocation == TeamPropLocation.LEFT_SPIKE){
                    trajectory = robot.nav.trajectoryBuilder(currentPose, false)
                            .back(12)
                            .build();

                } else if (teamPropLocation == TeamPropLocation.MIDDLE_SPIKE){
                    trajectory = robot.nav.trajectoryBuilder(currentPose, false)
                            .back(24)
                            .build();

                } else  if (teamPropLocation == TeamPropLocation.RIGHT_SPIKE){
                    trajectory = robot.nav.trajectoryBuilder(currentPose, false)
                            .back(12)
                            .build();
                }


                robot.nav.follower.followTrajectory(trajectory);
                break;
            case FORWARD:

                if (robot.nav.isDoneFollowing(currentPose)) {
                    if (teamPropLocation == TeamPropLocation.LEFT_SPIKE){
                        if (robot.nav.isDoneFollowing(currentPose)) {
                            robot.nav.turnAsync(-0.25*Math.PI);
                        }
                    } else if (teamPropLocation == TeamPropLocation.RIGHT_SPIKE) {
                        if (robot.nav.isDoneFollowing(currentPose)) {
                            robot.nav.turnAsync(0.25*Math.PI);
                        }

                    }
                    state = State.TURN;

                }



                break;


            case TURN:
                state = State.FORWARD_TO_TAPE;
                if (robot.nav.isDoneFollowing(currentPose)) {


                    if (teamPropLocation == TeamPropLocation.LEFT_SPIKE) {
                        trajectory = robot.nav.trajectoryBuilder(currentPose, false)
                                .back(7)
                                .build();


                    } else if (teamPropLocation == TeamPropLocation.RIGHT_SPIKE) {
                        trajectory = robot.nav.trajectoryBuilder(currentPose, false)
                                .back(7)
                                .build();
                    }
                }
                break;
            case FORWARD_TO_TAPE:
                if (robot.nav.isDoneFollowing(currentPose)) {
                    state = State.DONE;
                }



                break;
            case DONE:
                break;

        }


    }
}