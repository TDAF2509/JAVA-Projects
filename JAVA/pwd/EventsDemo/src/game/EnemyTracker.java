package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Pan the view to follow a particular body.
 */
public class EnemyTracker implements StepListener {
    /** The view */
    private WorldView view;

    /** The body */
    private Enemy enemy;

    private static final int WALKING_SPEED = 5;

    public EnemyTracker(WorldView view, Enemy enemy) {
        this.view = view;
        this.enemy = enemy;
    }

    @Override
    public void preStep(StepEvent e) {
        if(enemy.getPosition().x<95){
            enemy.startWalking(WALKING_SPEED);
            enemy.removeAllImages();
            AttachedImage at = new AttachedImage(enemy,enemy.getEnemyImage(),1,0,new Vec2(0,0));
            at.flipHorizontal();
        }else if (enemy.getPosition().x>115){
            enemy.startWalking(-WALKING_SPEED);
            enemy.removeAllImages();
            AttachedImage at = new AttachedImage(enemy,enemy.getEnemyImage(),1,0,new Vec2(0,0));
        }


    }

    @Override
    public void postStep(StepEvent e) {

    }

}