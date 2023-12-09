package org.firstinspires.ftc.teamcode.ftc16072.OpModes;

import com.acmerobotics.roadrunner.geometry.Pose2d;

import org.firstinspires.ftc.teamcode.ftc16072.Util.Navigation;

public class AutoBase extends QQOpMode{
    Navigation nav;
    public enum TeamColor{
        RED,
        BLUE
    }
    public TeamColor teamColor;
    boolean isFarSide;
    public boolean isCloseSide;
    public boolean getIsCloseSide(){
        return isCloseSide;
    }


    @Override
    public void init() {
        super.init();

    }

    @Override
    public void init_loop() {
        super.init_loop();
        if (gamepad1.left_bumper){
            isCloseSide = true;
            isFarSide = false;

        }
        if (gamepad1.right_bumper){
            isFarSide = true;
            isCloseSide = false;
        }
    }

    public void start(){
        if (isCloseSide){
            nav.setPoseEstimate(new Pose2d(2+36,2,0)); //TODO edit values
        } else {
            nav.setPoseEstimate(new Pose2d(2-26,2,0)); //TODO edit values
        }
    }
    @Override

    public void loop() {




    }
    public void setTeamColor(TeamColor teamColor){
        this.teamColor= teamColor;

    }
}
