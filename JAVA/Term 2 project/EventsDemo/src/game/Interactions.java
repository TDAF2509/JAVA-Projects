package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Collision listener that allows the bird to collect things.
 */
public class Interactions implements CollisionListener {
    private Sonic sonic;
    private Ring ring;
    private Health health;
    private Enemy enemy;
    
    public Interactions(Sonic sonic, Health health) {
        this.sonic = sonic;
        this.ring = ring;
        this.health = health;
        this.enemy = enemy;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == sonic) {
            if (e.getReportingBody() instanceof Ring){
                sonic.incrementRingCount();
            }else if (e.getReportingBody() instanceof Health){
                sonic.incrementHealth();
            }
            e.getReportingBody().destroy();

        }
        if (e.getOtherBody()==sonic){
            if (e.getReportingBody() instanceof Enemy){
                if (sonic.getRingCount()==0){
                    if (sonic.getHealth() == 0){
                        sonic.removeAllImages();
                        AttachedImage at = new AttachedImage(sonic,sonic.getSonicImageGameOver(),1,0,new Vec2(0,0));
                        System.out.println("game over");
                    }else {
                        sonic.reduceHealth();
                        sonic.removeAllImages();
                        AttachedImage at = new AttachedImage(sonic,sonic.getSonicImageGameOver(),1,0,new Vec2(0,0));
                    }
                }else{
                    sonic.reduceRingCount();
                    sonic.removeAllImages();
                    AttachedImage at = new AttachedImage(sonic,sonic.getSonicImageHit(),1,0,new Vec2(0,0));
                    sonic.applyForce(new Vec2(6500*-sonic.getLinearVelocity().x,9500*-sonic.getLinearVelocity().y));
                }

            }
        }

    }
    
}
