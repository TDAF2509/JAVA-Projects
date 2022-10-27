package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class Controller extends KeyAdapter {
    private static  float JUMPING_SPEED = 15;
    private static  float WALKING_SPEED = 4;
    private Walker body;
    private Sonic sonic;

    float gravity =5;

    public Controller(Walker body) {
        this.body = body;
    }


    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_UP) { // UP = jump
            Vec2 v = body.getLinearVelocity();


            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
                //body.setGravityScale(1.5f);
                body.removeAllImages();
                AttachedImage at = new AttachedImage(body,((Sonic) body).getSonicImageSpin(),0.8f,0,new Vec2(0,0));
            }
        } else if (code == KeyEvent.VK_LEFT) {// LEFT = walk left
            WALKING_SPEED+=.3f;
            body.startWalking(-WALKING_SPEED);
            body.removeAllImages();
            AttachedImage at = new AttachedImage(body,((Sonic) body).getSonicImageRun(),1,0,new Vec2(0,0));
            at.flipHorizontal();
        } else if (code == KeyEvent.VK_RIGHT) {// RIGHT = walk right
            WALKING_SPEED+=.3f;
            body.startWalking(WALKING_SPEED);
            body.removeAllImages();
            AttachedImage at = new AttachedImage(body,((Sonic)body).getSonicImageRun(),1,0,new Vec2(0,0));
        }else if (code == KeyEvent.VK_DOWN ){
            body.removeAllImages();
            AttachedImage at = new AttachedImage(body,((Sonic) body).getSonicImageDownSpin(),1,0,new Vec2(0,0));
            if (code == KeyEvent.VK_SPACE ){
                body.applyForce(new Vec2(body.getPosition().x*2000,body.getPosition().y));
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            body.stopWalking();
            body.removeAllImages();
            AttachedImage at = new AttachedImage(body,((Sonic)body).getSonicImageStatic(),1,0,new Vec2(0,0));
            at.flipHorizontal();
            WALKING_SPEED=4;
        } else if (code == KeyEvent.VK_RIGHT) {
            body.stopWalking();
            body.removeAllImages();
            AttachedImage at = new AttachedImage(body,((Sonic)body).getSonicImageStatic(),1,0,new Vec2(0,0));
            WALKING_SPEED=4;
        }else if (code == KeyEvent.VK_DOWN ){
            body.removeAllImages();
            AttachedImage at = new AttachedImage(body,((Sonic) body).getSonicImageStatic(),1,0,new Vec2(0,0));
        }
    }
}
