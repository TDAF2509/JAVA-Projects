package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.io.IOException;

/**
 * Pan the view to follow a particular body.
 */
public class EnemyTracker implements StepListener {
    /** The view */
    private WorldView view;

    /** The body */
    private Game game;

    private static final int WALKING_SPEED = 5;

    public EnemyTracker(WorldView view, Game game) {
        this.view = view;
        this.game = game;
    }

    @Override
    public void preStep(StepEvent e) {
        if(game.world.getEnemy().getPosition().x<95){
            game.world.getEnemy().startWalking(WALKING_SPEED);
            game.world.getEnemy().removeAllImages();
            AttachedImage at = new AttachedImage(game.world.getEnemy(),game.world.getEnemy().getEnemyImage(),1,0,new Vec2(0,0));
            at.flipHorizontal();
        }else if (game.world.getEnemy().getPosition().x>115){
            game.world.getEnemy().startWalking(-WALKING_SPEED);
            game.world.getEnemy().removeAllImages();
            AttachedImage at = new AttachedImage(game.world.getEnemy(),game.world.getEnemy().getEnemyImage(),1,0,new Vec2(0,0));
        }

    }

    @Override
    public void postStep(StepEvent e) {

    }

}