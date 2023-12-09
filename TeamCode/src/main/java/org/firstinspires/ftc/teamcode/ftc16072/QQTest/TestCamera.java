package org.firstinspires.ftc.teamcode.ftc16072.QQTest;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;

public class TestCamera extends QQtest{
    WebcamName webcamName;

    public TestCamera(String name, WebcamName webcamName){
        super(name);
        this.webcamName = webcamName;
    }
    @Override
    public void run(boolean on, Telemetry telemetry) {
        //telemetry.addData("Is Camera Attached", webcamName.isAttached());
    }
}
