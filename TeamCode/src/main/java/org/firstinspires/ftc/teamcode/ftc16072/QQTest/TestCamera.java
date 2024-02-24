package org.firstinspires.ftc.teamcode.ftc16072.QQTest;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.ftc16072.Util.TeamPropDetector;

public class TestCamera extends QQtest {
    TeamPropDetector teamPropDetector;
    WebcamName webcamName;

    public TestCamera(String name, WebcamName webcamName, TeamPropDetector teamPropDetector) {
        super(name);
        this.webcamName = webcamName;
        this.teamPropDetector = teamPropDetector;
    }

    @Override
    public void run(boolean on, Telemetry telemetry) {
        telemetry.addData("Is Camera Attached", webcamName.isAttached());
        telemetry.addData("teamProplocation: ", teamPropDetector.getPropLocation());

    }
}
