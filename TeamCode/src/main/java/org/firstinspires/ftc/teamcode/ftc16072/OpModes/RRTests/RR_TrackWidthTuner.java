package org.firstinspires.ftc.teamcode.ftc16072.OpModes.RRTests;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.util.Angle;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.MovingStatistics;

import org.firstinspires.ftc.robotcore.internal.system.Misc;
import org.firstinspires.ftc.teamcode.ftc16072.Mechanisms.MecanumDrive;
import org.firstinspires.ftc.teamcode.ftc16072.Robot;

@Disabled
@Autonomous(group = "RR")
public class RR_TrackWidthTuner extends OpMode {
    public static double TURN_ANGLE_DEGREES = 180;
    public static int NUM_TRIALS = 5;
    public static int DELAY_SEC = 1;
    Robot robot = new Robot();

    private enum State {BEGIN, TURNING, DONE_TURNING, FINISHED}

    State state = State.BEGIN;
    MovingStatistics trackWidthStats;
    int trial;
    double headingAccumulator;
    double lastHeading;
    double nextTurnTime;

    @Override
    public void init() {
        robot.makeDriveOnly();
        robot.init(hardwareMap);
        telemetry = new MultipleTelemetry(this.telemetry, FtcDashboard.getInstance().getTelemetry());
        telemetry.addLine("Press play to begin the track width tuner routine");
        telemetry.addLine("Make sure your robot has enough clearance to turn smoothly");
        telemetry.update();
    }

    @Override
    public void start(){
        telemetry.clearAll();
        telemetry.addLine("Running...");
        telemetry.update();
        trackWidthStats = new MovingStatistics(NUM_TRIALS);
        trial = 0;
        state = State.BEGIN;
    }

    @Override
    public void loop() {
        robot.nav.updatePoseEstimate();
        Pose2d currentPose = robot.nav.getPoseEstimate();

        telemetry.addData("STATE", state);
        telemetry.addData("POSE", "x = %.2f y = %.2f h = %.1f", currentPose.getX(), currentPose.getY(), Math.toDegrees(currentPose.getHeading()));

        switch (state) {
            case BEGIN:
                if(getRuntime() > nextTurnTime) {
                    robot.nav.setPoseEstimate(new Pose2d());

                    // it is important to handle heading wraparounds
                    headingAccumulator = 0;
                    lastHeading = 0;

                    robot.nav.turnAsync(Math.toRadians(TURN_ANGLE_DEGREES));
                    state = State.TURNING;
                }
                break;
            case TURNING:
                robot.nav.update();
                if(robot.nav.isBusy()){
                    headingAccumulator += Angle.normDelta(currentPose.getHeading() - lastHeading);
                    lastHeading = currentPose.getHeading();
                }
                else{
                    state = State.DONE_TURNING;
                }
                break;
            case DONE_TURNING:
                double trackWidth = MecanumDrive.TRACK_WIDTH_IN * Math.toRadians(TURN_ANGLE_DEGREES) / headingAccumulator;
                trackWidthStats.add(trackWidth);
                trial++;
                if(trial < NUM_TRIALS){
                    state = State.BEGIN;
                    nextTurnTime = getRuntime() + DELAY_SEC;
                }
                else{
                    state = State.FINISHED;
                }
                break;
            case FINISHED:
                telemetry.clearAll();
                telemetry.addLine("Tuning complete");
                telemetry.addLine(Misc.formatInvariant("Effective track width = %.2f (SE = %.3f)",
                        trackWidthStats.getMean(),
                        trackWidthStats.getStandardDeviation() / Math.sqrt(NUM_TRIALS)));
                break;
        }
    }
}
