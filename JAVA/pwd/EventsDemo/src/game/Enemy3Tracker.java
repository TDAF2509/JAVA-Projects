package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Pan the view to follow a particular body.
 */
public class Enemy3Tracker implements StepListener {
    /** The view */
    private WorldView view;

    /** The body */
    private Enemy3 enemy3;
    private Sonic sonic;

    private static final float WALKING_SPEED =4;

    public Enemy3Tracker(WorldView view, Enemy3 enemy3) {
        this.view = view;
        this.enemy3 = enemy3;
    }

    @Override
    public void preStep(StepEvent e) {
        if(enemy3.getPosition().x<150){
            enemy3.startWalking(WALKING_SPEED);
        }else if (enemy3.getPosition().x>170){
            enemy3.startWalking(-WALKING_SPEED);
        }
    }

    @Override
    public void postStep(StepEvent e) {

    }

}