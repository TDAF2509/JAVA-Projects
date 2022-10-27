package game;

import city.cs.engine.*;
import org.jbox2d.common.Timer;
import org.jbox2d.common.Vec2;

import java.io.IOException;

/**
 * Pan the view to follow a particular body.
 */
public class SonicTracker implements StepListener {
    /** The view */
    private WorldView view;

    /** The body */
    private Sonic sonic;

    private GameLevel gameWorld;

    public SonicTracker(WorldView view, Sonic sonic, GameLevel gameWorld) {
        this.view = view;
        this.sonic = sonic;
        this.gameWorld=gameWorld;
    }

    @Override
    public void preStep(StepEvent e) {

    }

    @Override
    public void postStep(StepEvent e) {
        if (gameWorld.gameLevel() == 1 || gameWorld.gameLevel() == 2){view.setCentre(new Vec2(sonic.getPosition()));}


    }
    
}
