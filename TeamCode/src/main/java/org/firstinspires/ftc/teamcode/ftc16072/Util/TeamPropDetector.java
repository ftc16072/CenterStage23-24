package org.firstinspires.ftc.teamcode.ftc16072.Util;

import android.graphics.Canvas;

import org.firstinspires.ftc.robotcore.internal.camera.calibration.CameraCalibration;
import org.firstinspires.ftc.vision.VisionProcessor;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;

public class TeamPropDetector implements VisionProcessor {
    //makes "detection zones" for each tape zone
    public Rect leftTapeDetectionZone = new Rect(20,20,50,50);
    public Rect middleTapeDetectionZone = new Rect(20,20,50,50);
    public Rect rightTapeDetectionZone = new Rect(20,20,50,50);

    //submats are smaller portions of the frame that you can get values from
    Mat submat = new Mat();
    Mat hsvMat = new Mat();

    @Override
    public void init(int width, int height, CameraCalibration calibration) {

    }



    @Override
    public Object processFrame(Mat frame, long captureTimeNanos) {


        return null;
    }

    //gets average hsv values from a specific submat created earlier
    //parameters are submat to be used and location of submat on frame
    protected Scalar getAvgHSV(Mat input, Rect rect){
        //find color from submat
        submat = input.submat(rect);
        Scalar color = Core.mean(submat);
        return color;
    }

    //scales rectangle to
    private android.graphics.Rect makeGraphicsRect (Rect rect, float scaleBmpPxToCanvasPx){
        int left =  Math.round(rect.x*scaleBmpPxToCanvasPx);
        int top = Math.round(rect.y*scaleBmpPxToCanvasPx);
        int right = left + Math.round(rect.width*scaleBmpPxToCanvasPx);
        int bottom = top + Math.round(rect.height*scaleBmpPxToCanvasPx);

        return new android.graphics.Rect(left,top,right,bottom);



    }


    @Override
    public void onDrawFrame(Canvas canvas, int onscreenWidth, int onscreenHeight, float scaleBmpPxToCanvasPx, float scaleCanvasDensity, Object userContext) {


    }
}
