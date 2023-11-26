package org.firstinspires.ftc.teamcode.ftc16072.Util;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.acmerobotics.roadrunner.geometry.Pose2d;

import org.firstinspires.ftc.robotcore.internal.camera.calibration.CameraCalibration;
import org.firstinspires.ftc.vision.VisionProcessor;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;

public class PixelDetector implements VisionProcessor {
    //makes "detection zones" for each tape zone
    TeamPropLocation location = TeamPropLocation.NOT_DETECTED;

    //submats are smaller portions of the frame that you can get values from
    Mat submat = new Mat();
    Mat hsvMat = new Mat();
    public Scalar lower_white = new Scalar(11.3, 0.0, 82.2, 0.0);
    public Scalar upper_white = new Scalar(107.7, 121.8, 255.0, 0.0);
    public double focalLength= 0.15748; //in

    public double pixelWidth = 3.5;
    public int contourListLength;
    public int count;
    public Rect rectangle;



    Mat outmat = new Mat();

    public double x;
    public double y;
    public double w;
    public double h;
    @Override
    public void init(int width, int height, CameraCalibration calibration) {

    }

    public double getDistanceToPixel(){
        return (focalLength*pixelWidth)/w;



    }
    public int getContourListLength(){
        return contourListLength;
    }
    public int getCount(){
        return count;
    }
    public double getHeadingToPixel(){
        return 55*(x/640);
    }







    @Override
    public Object processFrame(Mat frame, long captureTimeNanos) {

        Imgproc.cvtColor(frame, frame, Imgproc.COLOR_RGB2HSV);
        Core.inRange(frame,lower_white,upper_white,frame);
        List<MatOfPoint> contours = new ArrayList<>();
        Mat binary = new Mat();
        Mat hierarchy = new Mat();
        Imgproc.GaussianBlur(frame,frame, new  Size(19,19),0);
        Imgproc.findContours(frame,contours,hierarchy,Imgproc.RETR_TREE, Imgproc.CHAIN_APPROX_SIMPLE);
        contourListLength = contours.size();

        for (MatOfPoint cnt : contours) {
            x = 0;
            y = 0;
            w = 0;
            h = 0;
            MatOfPoint2f curve = new MatOfPoint2f(cnt.toArray());
            count = 0;

            //Imgproc.approxPolyDP(curve, curve, Imgproc.arcLength(curve, true) * 0.02, true);

            count = count + 1 ;
            rectangle = Imgproc.boundingRect(curve);
            x = rectangle.x;
            y = rectangle.y;
            w = rectangle.width;
            h = rectangle.height;






        }
        return null;
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
        android.graphics.Rect pixel = makeGraphicsRect(rectangle,scaleBmpPxToCanvasPx);

        Paint selectedColor = new Paint();
        selectedColor.setColor(Color.GREEN);
        canvas.drawRect(pixel,selectedColor);



    }
}
