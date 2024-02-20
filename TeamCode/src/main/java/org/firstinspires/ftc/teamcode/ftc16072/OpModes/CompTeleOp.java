package org.firstinspires.ftc.teamcode.ftc16072.OpModes;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.BaseNodes.Node;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trees.TeleopTree;
@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class CompTeleOp extends  QQOpMode{

    Node root = TeleopTree.root();

    boolean done;
    public void init_loop(){
        telemetry.addData("right saturation",robot.cameraBack.teamPropDetector.rightSaturation);
        telemetry.addData("middle saturation", robot.cameraBack.teamPropDetector.middleSaturation);
    }

    @Override
    public void loop() {
        if(!done){
            debug.reset();
            debug.addNode(root);
            Node.State state = root.tick(this);
            debug.updateNode(root, state);
            telemetry.addData("Tree", debug);
            if(state == Node.State.SUCCESS){
                done = true;
            }
        }
    }

}
