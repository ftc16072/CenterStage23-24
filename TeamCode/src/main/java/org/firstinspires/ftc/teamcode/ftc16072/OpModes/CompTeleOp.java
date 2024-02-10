package org.firstinspires.ftc.teamcode.ftc16072.OpModes;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trees.PushbotTeleop;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trees.TeleopTree;
@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class CompTeleOp extends  QQOpMode{

    Node root = PushbotTeleop.root();

    boolean done;
    public void init_loop(){
        telemetry.addData("right saturation",robot.cameraBack.teamPropDetector.rightSaturation);
        telemetry.addData("middle saturation", robot.cameraBack.teamPropDetector.middleSaturation);
    }

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
