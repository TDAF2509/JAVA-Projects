package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Pan the view to follow a particular body.
 */
public class Enemy2Tracker implements StepListener {
    /** The view */
    private WorldView view;

    /** The body */
    Enemy2 enemy2;

    public Enemy2Tracker(WorldView view, Enemy2 enemy2) {
        this.view = view;
        this.enemy2 = enemy2;
    }

    @Override
    public void preStep(StepEvent e) {
        if(enemy2.getPosition().y<-18){
            enemy2.applyForce(new Vec2(0,3000));
        }else if (enemy2.getPosition().y>0){
            enemy2.applyForce(new Vec2(0,-1000));
            enemy2.setGravityScale(9.8f);
        }


    }

    @Override
    public void postStep(StepEvent e) {

    }

}