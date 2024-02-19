package org.firstinspires.ftc.teamcode.ftc16072.OpModes.SpikeTrajectories;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.ftc16072.OpModes.SpikeAutoBase;
import org.firstinspires.ftc.teamcode.ftc16072.Util.Alliance;
import org.firstinspires.ftc.teamcode.ftc16072.Util.StartPosition;

@Autonomous
public class RedFar_SpikeAuto extends SpikeAutoBase {
    @Override
    public void init(){
        board.add("Alliance", Alliance.RED);
        board.add("StartPosition", StartPosition.FAR);
        super.init();
    }
}
