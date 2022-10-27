package game;

import city.cs.engine.AttachedImage;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import city.cs.engine.WorldView;
import org.jbox2d.common.Vec2;

public class EggmanTracker implements StepListener {
    /** The view */
    private WorldView view;

    /** The body */
    private EggMan eggMan;
    private EggManDefeated eggManDefeated;

    private static final float WALKING_SPEED =10;

    public EggmanTracker(WorldView view, EggMan eggMan, EggManDefeated eggManDefeated) {
        this.view = view;
        this.eggMan = eggMan;
        this.eggManDefeated = eggManDefeated;
    }

    @Override
    public void preStep(StepEvent e) {
        if(eggMan.getPosition().x>13){
            eggMan.startWalking(-WALKING_SPEED);
            eggMan.removeAllImages();
            AttachedImage at = new AttachedImage(eggMan,eggMan.getEggDrill(),1,0,new Vec2(0,0));
            at.flipHorizontal();
        }else if (eggMan.getPosition().x<-13){
            eggMan.startWalking(WALKING_SPEED);
            eggMan.removeAllImages();
            AttachedImage at = new AttachedImage(eggMan,eggMan.getEggDrill(),1,0,new Vec2(0,0));
        }

//        if (eggMan.getHit()>=20){
//            eggManDefeated.applyForce(new Vec2(0,1000));
//            if (eggManDefeated.getPosition().y>10){
//                eggManDefeated.applyForce(new Vec2(-1000,0));
//            }
//        }
    }

    @Override
    public void postStep(StepEvent e) {

    }

}
