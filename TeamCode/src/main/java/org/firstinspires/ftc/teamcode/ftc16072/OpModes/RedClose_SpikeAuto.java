package org.firstinspires.ftc.teamcode.ftc16072.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.ftc16072.Util.Alliance;
import org.firstinspires.ftc.teamcode.ftc16072.Util.StartPosition;

@Autonomous
public class RedClose_SpikeAuto extends SpikeAutoBase {
    @Override
    public void init(){
        board.add("Alliance", Alliance.RED);
        board.add("StartPosition", StartPosition.CLOSE);
        super.init();
    }
}
