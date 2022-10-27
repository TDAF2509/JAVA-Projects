package game;

import city.cs.engine.*;

//collisionlistener allows player to pick up coins
public class Pickup implements CollisionListener {
    private Goku sayan;
    
    public Pickup(Goku sayan) {
        this.sayan = sayan;
    }

    @Override
    public void collide(CollisionEvent e) {

        //when player collides with the energy ball, energy count increases by one, if it collides with health object,
        //the health count increases
        if (e.getOtherBody() == sayan) {
            if(e.getReportingBody() instanceof Energy){
                sayan.incrementEnergyCount();
            } else if(e.getReportingBody() instanceof Health){
                sayan.incrementHealthCount();
            }
            e.getReportingBody().destroy();
        }

        //if it collides with the enemy, the health count goes down by one
        if(e.getOtherBody() == sayan){
            if(e.getReportingBody() instanceof Enemy){
                sayan.reduceHealthCount();
            }
        }

    }
    
}