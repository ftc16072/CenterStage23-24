package org.firstinspires.ftc.teamcode.ftc16072.OpModes;

import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Node;
import org.firstinspires.ftc.teamcode.ftc16072.BehaviorTrees.Trees.AutoTree;

public class BlueSideAuto extends AutoBase{
    Node root = AutoTree.root();
    boolean done;
    public void init(){
        setTeamColor(TeamColor.BLUE);
    }

    public void loop(){
        if(!done){
            Node.State state = root.tick(this);
            if(state == Node.State.SUCCESS){
                done = true;
            }
        }

    }



}
