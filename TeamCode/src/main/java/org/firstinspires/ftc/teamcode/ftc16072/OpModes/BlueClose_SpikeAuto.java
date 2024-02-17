package org.firstinspires.ftc.teamcode.ftc16072.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trees.SpikeAutoTree;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trees.TeleopTree;
import org.firstinspires.ftc.teamcode.ftc16072.Util.Alliance;
import org.firstinspires.ftc.teamcode.ftc16072.Util.StartPosition;
@Autonomous
public class BlueClose_SpikeAuto extends SpikeAutoBase {



    @Override
    public void init(){
        super.init();
        board.add("Alliance", Alliance.BLUE);
        board.add("StartPosition", StartPosition.CLOSE);


    }

    @Override
    public void init_loop() {
        super.init_loop();
        telemetry.addData("Prop Location: ", robot.cameraBack.getTeamPropPosition());
    }
}
