package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Controller extends KeyAdapter {
    private static  float JUMPING_SPEED = 12;
    private static  float WALKING_SPEED = 4;
    private Sonic sonic;
    private SoundClip sound;

    public Controller(Sonic sonic) {
        this.sonic = sonic;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_UP) { // UP = jump
            Vec2 v = sonic.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 5.01f) {
                sonic.jump(JUMPING_SPEED);
                sonic.removeAllImages();
                AttachedImage at = new AttachedImage(sonic,Sonic.getSonicImageSpin(),0.8f,0,new Vec2(0,0));
                try {
                    sound = new SoundClip("data/Jump Sound.wav");   // Open an audio input stream
                    sound.play();  // Set it to play once
                } catch (UnsupportedAudioFileException |IOException |LineUnavailableException s) {
                    System.out.println(s);
                }
            }
        } else if (code == KeyEvent.VK_LEFT) {// LEFT = walk left
            WALKING_SPEED+=.3f;
            sonic.startWalking(-WALKING_SPEED);
            sonic.removeAllImages();
            AttachedImage at = new AttachedImage(sonic,Sonic.getSonicImageRun(),1.1f,0,new Vec2(0,0));
            at.flipHorizontal();
        } else if (code == KeyEvent.VK_RIGHT) {// RIGHT = walk right
            if (sonic.getPosition().x>11f && sonic.getPosition().x<13f && sonic.getPosition().y>-9 && sonic.getPosition().y<-7){
                WALKING_SPEED+=55.3f;
            }else {
                WALKING_SPEED+=.3f;
            }
            WALKING_SPEED+=.3f;
            sonic.startWalking(WALKING_SPEED);
            sonic.removeAllImages();
            AttachedImage at = new AttachedImage(sonic,Sonic.getSonicImageRun(),1.1f,0,new Vec2(0,0));

        }else if (code == KeyEvent.VK_DOWN ){
            sonic.removeAllImages();
            AttachedImage at = new AttachedImage(sonic,Sonic.getSonicImageDownSpin(),0.8f,0,new Vec2(0,0));
            if (code == KeyEvent.VK_SPACE ){
                sonic.applyForce(new Vec2(sonic.getPosition().x*2000,sonic.getPosition().y));
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            sonic.stopWalking();
            sonic.removeAllImages();
            AttachedImage at = new AttachedImage(sonic,Sonic.getSonicImageStatic(),1,0,new Vec2(0,0));
            at.flipHorizontal();
            WALKING_SPEED=4;
        } else if (code == KeyEvent.VK_RIGHT) {
            sonic.stopWalking();
            sonic.removeAllImages();
                AttachedImage at = new AttachedImage(sonic,Sonic.getSonicImageStatic(),1,0,new Vec2(0,0));
            WALKING_SPEED=4;
        }else if (code == KeyEvent.VK_DOWN ){
            sonic.removeAllImages();
            AttachedImage at = new AttachedImage(sonic,Sonic.getSonicImageStatic(),1,0,new Vec2(0,0));
        }
    }

    public void setBody(Sonic sonic){this.sonic = sonic;}

    public void setWalkingSpeed(float walkingSpeed) {
        WALKING_SPEED = walkingSpeed;
    }
}
