package org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Actions;

import com.acmerobotics.roadrunner.trajectory.Trajectory;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.OpModes.QQOpMode;
import org.firstinspires.ftc.teamcode.ftc16072.Util.Alliance;
import org.firstinspires.ftc.teamcode.ftc16072.Util.SpikePosition;
import org.firstinspires.ftc.teamcode.ftc16072.Util.StartPosition;
import org.firstinspires.ftc.teamcode.rr_trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.rr_trajectorysequence.TrajectorySequenceBuilder;

public class SetBackboardFromSpikeTrajectory extends Node {
    @Override
    public State tick(QQOpMode opmode) {
        Alliance alliance = opmode.board.get(Alliance.class, "Alliance");
        StartPosition startPosition = opmode.board.get(StartPosition.class,"StartPosition");
        SpikePosition spikePosition = opmode.board.get(SpikePosition.class,"SpikePosition");
        TrajectorySequenceBuilder builder = opmode.robot.nav.trajectorySequenceBuilder(opmode.robot.nav.getPoseEstimate());
        TrajectorySequence sequence = null;

        if(alliance == Alliance.RED){
            if(startPosition == StartPosition.CLOSE){
                if(spikePosition == SpikePosition.LEFT){
                    //TODO: Put RedCloseLeft trajectory builder here
                } else if (spikePosition == SpikePosition.RIGHT) {
                    //TODO: Put REDCLOSERight trajectory builder here
                }
                else if (spikePosition == SpikePosition.MIDDLE){
                    //TODO: Put REDCLOSEMIDDLE trajectory builder here
                }
            } else if (startPosition == StartPosition.FAR){
                if(spikePosition == SpikePosition.LEFT){
                    //TODO: Put RedFarLeft trajectory builder here
                } else if (spikePosition == SpikePosition.RIGHT) {
                    //TODO: Put REDFarRight trajectory builder here
                }
                else if (spikePosition == SpikePosition.MIDDLE){
                    //TODO: Put REDFarMIDDLE trajectory builder here
                }
            }
        }
        if(alliance == Alliance.BLUE){
            if(startPosition == StartPosition.CLOSE){
                if(spikePosition == SpikePosition.LEFT){
                    //TODO: Put BlueCloseLeft trajectory builder here
                } else if (spikePosition == SpikePosition.RIGHT) {
                    //TODO: Put BlueCLOSERight trajectory builder here
                }
                else if (spikePosition == SpikePosition.MIDDLE){
                    //TODO: Put BlueCLOSEMIDDLE trajectory builder here
                }
            } else if (startPosition == StartPosition.FAR){
                if(spikePosition == SpikePosition.LEFT){
                    //TODO: Put BlueFarLeft trajectory builder here
                } else if (spikePosition == SpikePosition.RIGHT) {
                    //TODO: Put BlueFarRight trajectory builder here
                }
                else if(spikePosition == SpikePosition.MIDDLE){
                    //TODO: Put BlueFarMIDDLE trajectory builder here
                }
            }
        }

        if (sequence == null){
            return State.FAILURE;
        }
        opmode.board.add("TrajectorySequence", sequence);
        return State.SUCCESS;
    }
}
