package org.firstinspires.ftc.teamcode.ftc16072.Mechanisms;

import com.qualcomm.robotcore.hardware.ColorRangeSensor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.QQtest;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestColorRangeSensor;
import org.firstinspires.ftc.teamcode.ftc16072.QQTest.TestSwitch;

import java.util.Arrays;
import java.util.List;

public class HoldingCell implements Mechanism{
    public static final int PIXEL_THRESHOLD_MM = 20;

    private ColorRangeSensor leftPixelCounter;
    private ColorRangeSensor rightPixelCounter;

    private DigitalChannel leftConeDetector;

    private DigitalChannel rightConeDetector;


    @Override
    public void init(HardwareMap hwMap) {
        leftPixelCounter = hwMap.get(ColorRangeSensor.class, "left_pixel_counter");
        rightPixelCounter = hwMap.get(ColorRangeSensor.class, "right_pixel_counter");
        leftConeDetector = hwMap.get(DigitalChannel.class,"left_cone_detector");
        rightConeDetector = hwMap.get(DigitalChannel.class,"right_cone_detector");
    }

    public List<QQtest> getTests() {
        return Arrays.asList(
                new TestColorRangeSensor("left pixel detector", leftPixelCounter),
                new TestColorRangeSensor("right pixel detector", rightPixelCounter),
                new TestSwitch("left_cone_detector",leftConeDetector),
                new TestSwitch("right_cone_detector", rightConeDetector));
    }

    public boolean isConeDetected(){
        return leftConeDetector.getState() || rightConeDetector.getState();
    }
    /**
     * Checks how many pixels are in the holding cell.
     * @return 0,1,2 pixels
     */
    public int getNumPixels() {
        int numPixelsSeen = 0;
        if (leftPixelCounter.getDistance(DistanceUnit.MM) < PIXEL_THRESHOLD_MM) {
            numPixelsSeen++;
        }
        if (rightPixelCounter.getDistance(DistanceUnit.MM) < PIXEL_THRESHOLD_MM) {
            numPixelsSeen++;
        }
        return numPixelsSeen;
    }
}
