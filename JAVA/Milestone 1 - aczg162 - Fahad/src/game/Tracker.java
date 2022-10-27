package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

//to follow the player
public class Tracker implements StepListener {

    private WorldView view;

    private Body body;

    public Tracker(WorldView view, Body body) {
        this.view = view;
        this.body = body;
    }

    @Override
    public void preStep(StepEvent e) {
    }

    @Override
    public void postStep(StepEvent e) {
        if(body.getPosition().x < -30) {
            view.setCentre(new Vec2(0,0));
        } else if(body.getPosition().x > 15){
            view.setCentre(new Vec2(45,0));
        } else if(body.getPosition().x > -30){
            view.setCentre(new Vec2(body.getPosition().x+30,0));
        }
    }
    
}