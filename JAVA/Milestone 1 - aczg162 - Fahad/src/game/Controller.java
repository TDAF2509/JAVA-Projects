package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Controller extends KeyAdapter {
    private static final float JUMPING_SPEED = 13;
    private static final float WALKING_SPEED = 10;
    
    private Walker body;
    
    public Controller(Walker body) {
        this.body = body;
    }


    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_W) { // W = jump
            Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
            }
            System.out.println("Player jump");
        } else if (code == KeyEvent.VK_A) {
            body.startWalking(-WALKING_SPEED); // A = walk left
            body.removeAllImages();
            AttachedImage at = new AttachedImage(body, ((Goku) body).getBodyImage1(), 1, 0, new Vec2(0,0));
            at.flipHorizontal();
            System.out.println("Walk Left");
        } else if (code == KeyEvent.VK_D) {
            body.startWalking(WALKING_SPEED); // D = walk right
            body.removeAllImages();
            AttachedImage at = new AttachedImage(body, ((Goku) body).getBodyImage1(), 1, 0, new Vec2(0,0));
            System.out.println("Walk Right");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            body.stopWalking();
            body.removeAllImages();
            AttachedImage at = new AttachedImage(body, ((Goku) body).getBodyImage(), 1, 0, new Vec2(0,0));
            at.flipHorizontal();
        } else if (code == KeyEvent.VK_D) {
            body.stopWalking();
            body.removeAllImages();
            AttachedImage at = new AttachedImage(body, ((Goku) body).getBodyImage(), 1, 0, new Vec2(0,0));
        }
    }


}