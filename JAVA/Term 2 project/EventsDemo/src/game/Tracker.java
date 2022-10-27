package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Pan the view to follow a particular body.
 */
public class Tracker implements StepListener {
    /** The view */
    private WorldView view;

    /** The body */
    private Body body;

    private Enemy enemy;


    public Tracker(WorldView view, Body body) {
        this.view = view;
        this.body = body;
    }

    public Tracker(Enemy enemy){
        this.enemy = enemy;
    }

    @Override
    public void preStep(StepEvent e) {
//        if (enemy.getPosition().x <10){
//            enemy.startWalking(5);
//        }
    }

    @Override
    public void postStep(StepEvent e) {
//        if (this.body.getPosition().x<-30f){
//            this.view.setCentre(new Vec2(0,0));
//        }else if (this.body.getPosition().x>30){
//            this.view.setCentre(new Vec2(45,0));
//        }else if (this.body.getPosition().x>-30){
//            this.view.setCentre(new Vec2(this.body.getPosition().x+30,0));
//        }
        view.setCentre(new Vec2(body.getPosition()));
    }
    
}
