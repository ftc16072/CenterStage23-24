package org.firstinspires.ftc.teamcode.ftc16072.OpModes;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trees.TeleopTree;
@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class CompTeleOp extends  QQOpMode{

    Node root = TeleopTree.root();

    boolean done;


    @Override
    public void loop() {
        if(!done){
            Node.State state = root.tick(this);
            if(state == Node.State.SUCCESS){
                done = true;
            }
        }

    }



}
