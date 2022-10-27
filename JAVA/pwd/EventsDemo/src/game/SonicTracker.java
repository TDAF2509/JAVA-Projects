package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Pan the view to follow a particular body.
 */
public class SonicTracker implements StepListener {
    /** The view */
    private WorldView view;

    /** The body */
    private Sonic sonic;

    public SonicTracker(WorldView view, Sonic sonic) {
        this.view = view;
        this.sonic = sonic;
    }

    @Override
    public void preStep(StepEvent e) {

    }

    @Override
    public void postStep(StepEvent e) {
        if (Game.getLevel() == 1 || Game.getLevel() == 2){view.setCentre(new Vec2(sonic.getPosition()));}


    }
    
}
