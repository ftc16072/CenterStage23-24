package org.firstinspires.ftc.teamcode.ftc16072.Util;

import android.graphics.Canvas;
import android.provider.ContactsContract;

import org.firstinspires.ftc.robotcore.internal.camera.calibration.CameraCalibration;
import org.firstinspires.ftc.vision.VisionProcessor;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

public class TeamPropDetector implements VisionProcessor {
    //makes "detection zones" for each tape zone
    int parkingZone = 1;
    public Scalar rectangleColor = new Scalar(0, 255, 0);
    public Rect leftTapeDetectionZone = new Rect(140,100,50,50);
    public Rect middleTapeDetectionZone = new Rect(40,20,50,50);
    public Rect rightTapeDetectionZone = new Rect(70,30,50,50);

    //submats are smaller portions of the frame that you can get values from
    Mat submat = new Mat();
    Mat hsvMat = new Mat();

    @Override
    public void init(int width, int height, CameraCalibration calibration) {

    }



    @Override
    public Object processFrame(Mat frame, long captureTimeNanos) {
        Imgproc.cvtColor(frame, hsvMat, Imgproc.COLOR_RGB2HSV);
        Imgproc.rectangle(frame,leftTapeDetectionZone, rectangleColor);
        Imgproc.rectangle(frame,middleTapeDetectionZone, rectangleColor);
        Imgproc.rectangle(frame,rightTapeDetectionZone, rectangleColor);

        double RectLeft =  getAvgSaturation(hsvMat, leftTapeDetectionZone);
        double RectMiddle = getAvgSaturation(hsvMat, middleTapeDetectionZone);
        double RectRight  = getAvgSaturation(hsvMat, rightTapeDetectionZone);


        if((RectLeft>RectMiddle) && (RectLeft>RectRight)) {
            parkingZone = 1;
            return 1;
        } else if ((RectMiddle>RectLeft) && (RectMiddle>RectRight)){
            parkingZone = 2;
            return 2;
        }else if ((RectRight>RectMiddle) && (RectRight>RectLeft)){
            parkingZone = 3;
            return 3;
        }
        parkingZone = 1; // guess if it cant decide
        return 1;



    }
    public int getParkingZone(){
        return parkingZone;
    }

    //gets average hsv values from a specific submat created earlier
    //parameters are submat to be used and location of submat on frame
    protected double getAvgSaturation(Mat input, Rect rect){
        //find color from submat
        submat = input.submat(rect);
        Scalar color = Core.mean(submat);
        return color.val[1];
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
