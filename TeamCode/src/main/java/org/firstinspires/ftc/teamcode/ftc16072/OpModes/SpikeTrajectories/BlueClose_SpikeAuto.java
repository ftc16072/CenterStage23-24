package org.firstinspires.ftc.teamcode.ftc16072.OpModes.SpikeTrajectories;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.ftc16072.OpModes.SpikeAutoBase;
import org.firstinspires.ftc.teamcode.ftc16072.Util.Alliance;
import org.firstinspires.ftc.teamcode.ftc16072.Util.StartPosition;

@Autonomous
public class BlueClose_SpikeAuto extends SpikeAutoBase {

    @Override
    public void init() {
        super.init();
        board.add("Alliance", Alliance.BLUE);
        board.add("StartPosition", StartPosition.CLOSE);
    }
}
