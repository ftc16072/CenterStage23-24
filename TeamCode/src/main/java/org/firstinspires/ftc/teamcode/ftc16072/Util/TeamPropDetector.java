package org.firstinspires.ftc.teamcode.ftc16072.Util;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.acmerobotics.dashboard.config.Config;

import org.firstinspires.ftc.robotcore.internal.camera.calibration.CameraCalibration;
import org.firstinspires.ftc.vision.VisionProcessor;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
@Config
public class TeamPropDetector implements VisionProcessor {
    //makes "detection zones" for each tape zone
    TeamPropLocation location = TeamPropLocation.NOT_DETECTED;
    public Rect leftTapeDetectionZone = new Rect(100,100,75,75);
    public Rect middleTapeDetectionZone = new Rect(250,130,75,75);
    public Rect rightTapeDetectionZone = new Rect(400,100,75,75);

    //submats are smaller portions of the frame that you can get values from
    Mat submat = new Mat();
    Mat hsvMat = new Mat();

    @Override
    public void init(int width, int height, CameraCalibration calibration) {

    }



    @Override
    public Object processFrame(Mat frame, long captureTimeNanos) {
        Imgproc.cvtColor(frame, hsvMat, Imgproc.COLOR_RGB2HSV);

        double leftSaturation =  getAvgSaturation(hsvMat, leftTapeDetectionZone);
        double middleSaturation = getAvgSaturation(hsvMat, middleTapeDetectionZone);
        double rightSaturation  = getAvgSaturation(hsvMat, rightTapeDetectionZone);


        if((leftSaturation>middleSaturation) && (leftSaturation>rightSaturation)) {
            location = TeamPropLocation.LEFT_SPIKE;
        } else if ((middleSaturation>leftSaturation) && (middleSaturation>rightSaturation)){
            location = TeamPropLocation.MIDDLE_SPIKE;
        }else if ((rightSaturation>middleSaturation) && (rightSaturation>leftSaturation)){
            location = TeamPropLocation.RIGHT_SPIKE;
        }
        return location;

    }
    public TeamPropLocation getPropLocation(){
        return location;
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
        android.graphics.Rect coloredLeftZone = makeGraphicsRect(leftTapeDetectionZone,scaleBmpPxToCanvasPx);
        android.graphics.Rect coloredRightZone = makeGraphicsRect(rightTapeDetectionZone,scaleBmpPxToCanvasPx);
        android.graphics.Rect coloredMiddleZone = makeGraphicsRect(middleTapeDetectionZone,scaleBmpPxToCanvasPx);

        Paint selectedColor = new Paint();
        selectedColor.setColor(Color.GREEN);

        Paint unselectedColor = new Paint(selectedColor);
        unselectedColor.setColor(Color.RED);

        canvas.drawRect(coloredLeftZone,unselectedColor);
        canvas.drawRect(coloredRightZone,unselectedColor);
        canvas.drawRect(coloredMiddleZone,unselectedColor);

        switch(getPropLocation()){
            case LEFT_SPIKE:
                canvas.drawRect(coloredLeftZone,selectedColor);
                break;
            case RIGHT_SPIKE:
                canvas.drawRect(coloredRightZone,selectedColor);
                break;
            case MIDDLE_SPIKE:
                canvas.drawRect(coloredMiddleZone,selectedColor);
                break;

        }
    }
}
