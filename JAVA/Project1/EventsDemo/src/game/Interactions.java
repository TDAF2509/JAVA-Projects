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
public class Interactions implements CollisionListener {
    private Sonic sonic;
    private Enemy enemy;
    private Enemy2 enemy2;
    private Enemy3 enemy3;
    private EggMan eggMan;
    private SoundClip sound;
    private Game game;
    private Controller controller= new Controller(sonic);

    public Interactions(Sonic sonic,Enemy enemy, Enemy2 enemy2, Enemy3 enemy3, EggMan eggMan, Game game) {
        this.sonic = sonic;
        this.enemy = enemy;
        this.enemy2 = enemy2;
        this.enemy3 = enemy3;
        this.eggMan = eggMan;
        this.game = game;
    }
    @Override
    public void collide(CollisionEvent e) {
        //ReadingData readingData = new ReadingData("data/levelSaver.txt");

      /*  if (e.getReportingBody() instanceof Enemy && e.getReportingBody().getPosition().x == readingData.pos && game.getLevel() == readingData.level ){
            e.getReportingBody();
        }*/

        if (e.getOtherBody()==sonic){
            if (e.getReportingBody() instanceof Enemy || e.getReportingBody() instanceof Enemy3){
                if (sonic.getPosition().y>enemy.getPosition().y){
                    System.out.println("above");

                  /*  if (e.getReportingBody() instanceof Enemy) {
                        SavingData savingData = new SavingData("data/levelSaver.txt");
                        try {
                            savingData.saveGameLevel(game,e.getReportingBody().getPosition().x,-900,-900,-900);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }*/

                   /* if (e.getReportingBody() instanceof Enemy3) {
                        SavingData savingData = new SavingData("data/levelSaver.txt");
                        try {
                            savingData.saveGameLevel(game,-900,e.getReportingBody().getPosition().x,-900,-900);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }*/

                    try {
                        sound = new SoundClip("data/BadnikDefeated.wav");   // Open an audio input stream
                        sound.play();  // Set it to play once
                    } catch (UnsupportedAudioFileException |IOException |LineUnavailableException s) {
                        System.out.println(s);
                    }
                    e.getReportingBody().destroy();
                }else if (sonic.getRingCount()==0){
                    if (sonic.getHealth() == 0){
                        gameOver();
                        System.exit(0);
                        System.out.println("game over");
                    }else {
                        sonic.reduceHealth();
                        gameOver();
                        sonic.setPosition(new Vec2(-190, 10));
                    }
                }else{
                    hit();
                }
            }else if (e.getReportingBody() instanceof EggMan){
                if (eggMan.getEggFixture().getBody().getPosition().y<sonic.getPosition().y){
                    eggMan.incrementHit();
                    eggMan.removeAllImages();
                    AttachedImage at = new AttachedImage(eggMan,eggMan.getEggDrillHit(),1,0,new Vec2(0,0));
                    sonic.applyForce(new Vec2(0,1000));
                    if (eggMan.getLinearVelocity().x<0){
                        at.flipHorizontal();
                    }
                    if (eggMan.getHit()==20){
                        eggMan.removeAllImages();
                        e.getReportingBody().destroy();
                        System.exit(0);
                    }
                }else if (sonic.getRingCount()==0){
                    if (sonic.getHealth() == 0){
                        gameOver();
                        System.exit(0);
                        System.out.println("game over");
                    }else {
                        sonic.reduceHealth();
                        gameOver();
                        sonic.setPosition(new Vec2(-10, 10));
                    }
                }else{
                    hit();
                }
            }
        }else if (enemy2.intersects(sonic)){
            if (sonic.getRingCount()==0){

            }else{
                hit();
            }
        }
    }

    public void hit() {
        sonic.reduceRingCount();
        sonic.removeAllImages();
        AttachedImage at = new AttachedImage(sonic, sonic.getSonicImageHit(), 1, 0, new Vec2(0, 0));
        if (sonic.getLinearVelocity().x!=0){
            sonic.applyForce(new Vec2(6500 * -sonic.getLinearVelocity().x, 9500 * -sonic.getLinearVelocity().y));
        }else {
            sonic.applyForce(new Vec2(-6500,100));
        }

        try {
            sound = new SoundClip("data/Hit sound.wav");   // Open an audio input stream
            sound.play();  // Set it to play once
        } catch (UnsupportedAudioFileException |IOException |LineUnavailableException s) {
            System.out.println(s);
        }
    }

    public void gameOver(){
        sonic.removeAllImages();
        AttachedImage at = new AttachedImage(sonic,sonic.getSonicImageGameOver(),1,0,new Vec2(0,0));
        sonic.applyForce(new Vec2(0, 1000));
    }
}
