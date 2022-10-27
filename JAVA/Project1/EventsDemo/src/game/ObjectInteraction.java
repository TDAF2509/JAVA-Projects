package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;

/**
 * Collision listener that monitors the collisions of sonic and the objects in the world.
 */
public class ObjectInteraction implements CollisionListener {
    private Sonic sonic;
    private Bounce bounce;
    private Checkpoint checkpoint;
    private SoundClip sound;
    private Game game;
    private Controller controller = new Controller(sonic);
    //SavingData savingData = new SavingData("data/levelSaver.txt");

    public ObjectInteraction(Sonic sonic,Bounce bounce,Game game) {
        this.sonic = sonic;
        this.bounce = bounce;
        this.game=game;
    }
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == sonic){
            if (e.getReportingBody() instanceof  Spring){
                System.out.println("Collision");
                sonic.stopWalking();
                controller.setWalkingSpeed(4);
                sonic.applyForce(new Vec2(40000,30000));
                sonic.removeAllImages();
                AttachedImage at = new AttachedImage(sonic,Sonic.getSonicImageBounced(),1.1f,0,new Vec2(0,0));
            }
        }
        if (e.getOtherBody() == sonic){
            if (e.getReportingBody() instanceof PipeStart || e.getReportingBody() instanceof PipeMain){
                sonic.stopWalking();
                controller.setWalkingSpeed(4);
                sonic.applyForce(new Vec2(20000,-40000));
                System.out.println("Collision");
            }
        }
        if (e.getOtherBody() == sonic){
            if (e.getReportingBody() instanceof Bounce){
                if (sonic.getPosition().y>bounce.getPosition().y){
                    sonic.applyForce(new Vec2(0,50000));
                    sonic.removeAllImages();
                    AttachedImage at = new AttachedImage(sonic,Sonic.getSonicImageBounced(),1.1f,0,new Vec2(0,0));
                }
            }
        }

        if (e.getOtherBody() == sonic) {
            if (e.getReportingBody() instanceof Ring){
                sonic.incrementRingCount();

              /*  try {
                    savingData.saveGameLevel(game,null,null,e.getReportingBody().getPosition(),null);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }*/

                e.getReportingBody().destroy();
                try {
                    sound = new SoundClip("data/Ring Sound.wav");   // Open an audio input stream
                    sound.play();  // Set it to play once
                } catch (UnsupportedAudioFileException |IOException |LineUnavailableException s) {
                    System.out.println(s);
                }
            }else if (e.getReportingBody() instanceof Health){
                sonic.incrementHealth();

                /*try {
                    savingData.saveGameLevel(game,null,null,,);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }*/

                e.getReportingBody().destroy();
                try {
                    sound = new SoundClip("data/Health Sound.wav");   // Open an audio input stream
                    sound.play();  // Set it to play once
                } catch (UnsupportedAudioFileException |IOException |LineUnavailableException s) {
                    System.out.println(s);
                }
            }

        }

    }
}
