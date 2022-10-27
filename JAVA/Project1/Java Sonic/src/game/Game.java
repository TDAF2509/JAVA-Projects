package game;

import city.cs.engine.*;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import com.sun.demo.jvmti.hprof.Tracker;
import com.sun.deploy.panel.ControlPanel;
import javafx.scene.layout.Border;
import org.jbox2d.common.Vec2;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Game {

    /** The World in which the bodies move and interact. */
    public GameLevel world;

    /** A graphical display of the world (a specialised JPanel). */
    private UserView view;

    private static int level;

    private Controller controller;

    public SoundClip gamebgm;

    private Level1 level1;
    private Level2 level2;
    private Level3 level3;

    /** Initialise a new Game. */
    public Game() {
        level = 1;

        world = new Level1();
        world.populate(this);

        view = new Background(world,700,500,world);

        if (level==1) {

            try {
                gamebgm = new SoundClip("data/02 - Green Hill Zone.wav");   // Open an audio input stream
                gamebgm.loop();  // Set it to continous playback (looping)
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
        }

        // make a view
        // uncomment this to draw a 1-metre grid over the view
        view.setGridResolution(1);

        // display the view in a frame
        final JFrame frame = new JFrame("Sonic Game");
        ControlPanal controlPanal = new ControlPanal(this);
        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
//        frame.add(controlPanel,BorderLayout.NORTH);
        frame.add(controlPanal.MainControlPanal,BorderLayout.NORTH);
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
//        frame.add(controlPanel,BorderLayout.NORTH);
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();



        controller = new Controller(world.getSonic());
        frame.addKeyListener(controller);

        //Controls how the view is shown for the first two levels. View will follow the controlled character
        if (level==1 || level==2){
            world.addStepListener(new SonicTracker(view, world.getSonic(),world));
        }

        //Each step listener will control the movement of each body
        world.addStepListener(new Enemy3Tracker(view,world.getEnemy3()));
        world.addStepListener(new EnemyTracker(view,this));
        world.addStepListener(new Enemy2Tracker(view,world.getEnemy2()));

        // uncomment this to make a debugging view
//        JFrame debugView = new DebugViewer(world,500,500);



        // start!
        world.start();
        System.out.println("LEVEL = "+level);
    }

    public Sonic getSonic(){
        return world.getSonic();
    }

    public boolean isCurrentLevelCompleted(){
        return world.isCompleted();
    }

    public static int getLevel() {
        return level;
    }

    public void goToLevel(GameLevel lvl){
        world.stop();
        level = lvl.gameLevel();
            if (level==2){
                world = lvl;
                try {
                    gamebgm = new SoundClip("data/03 - Emerald Hill Zone.wav");   // Open an audio input stream
                    gamebgm.loop();  // Set it to continous playback (looping)
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    System.out.println(e);
                }
            }else if (level==3){
                world = lvl;
                try {
                    gamebgm = new SoundClip("data/16 - Robotnik.wav");   // Open an audio input stream
                    gamebgm.loop();  // Set it to continous playback (looping)
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    System.out.println(e);
                }
                // tracker for the final boss
                world.addStepListener(new EggmanTracker(view,world.getEggMan(),world.getEggmanDefeated()));

            }
            // recalibrates the controls nd screen when changing levels
            controller.setBody(world.getSonic());
            view.setWorld(world);
            world.addStepListener(new SonicTracker(view, world.getSonic(),world));


            world.start();
    }

    public void goNextLevel(){
        // Stops the world and music for each level change
        world.stop();
        gamebgm.stop();
        int ring = getSonic().getRingCount();
        int health = getSonic().getHealth();
        //Level selection based on the level variable
        if (level == 3){
            //Ends the game
            System.exit(0);
        }else{
            level++;
            System.out.println(getSonic().getRingCount());
            System.out.println(getSonic().getHealth());
            if (level==2){
                System.out.println("LEVEL = "+level);
                world = new Level2();
                try {
                    gamebgm = new SoundClip("data/03 - Emerald Hill Zone.wav");   // Open an audio input stream
                    gamebgm.loop();  // Set it to continous playback (looping)
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    System.out.println(e);
                }
            }else if (level==3){
                System.out.println("LEVEL = "+level);
                world = new Level3();
                try {
                    gamebgm = new SoundClip("data/16 - Robotnik.wav");   // Open an audio input stream
                    gamebgm.loop();  // Set it to continous playback (looping)
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    System.out.println(e);
                }
                world.addStepListener(new EggmanTracker(view,world.getEggMan(),world.getEggmanDefeated()));

            }
            // recalibrates the controls nd screen when changing levels and carries over the number of rings and health to next level
            world.populate(this);
            getSonic().setRingCount(ring);
            getSonic().setHealth(health);
            controller.setBody(world.getSonic());
            view.setWorld(world);
            world.addStepListener(new SonicTracker(view, world.getSonic(),world));

            // starts the world and allows movement;
            world.start();
        }

    }

    /** Run the game. */
    public static void main(String[] args) {
        //Calls the main menu
        MainMenu1 mainMenu1 = new MainMenu1();


    }
}
