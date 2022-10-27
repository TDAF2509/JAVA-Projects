package game;

import city.cs.engine.*;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import com.sun.demo.jvmti.hprof.Tracker;
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

    private SoundClip gamebgm;

//    private Focus focus = new Focus();

    /** Initialise a new Game. */
    public Game() {

        level = 1;
        // make the world
        //world = new GameWorld();

//        world =  new Level1();
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

//        ControlPanel controlPanel = new ControlPanel();
//        MainMenu mainMenu = new MainMenu(world);
//        JLabel version = new JLabel();
//        version.setText("Version 5.2");
//        frame.add(version,BorderLayout.SOUTH);

//        frame.add(mainMenu, BorderLayout.NORTH);

        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);



        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();


        controller = new Controller(world.getSonic());
        frame.addKeyListener(controller);
//        Sensor sensor = new Sensor(new Enemy2(world));

        //Tracker tracker = new Tracker(enemy);
//        view.setBounds(-208,0,3,50);

        // uncomment to make the view track the bird
        if (level==1 || level==2){
            world.addStepListener(new SonicTracker(view, world.getSonic()));
        }


        world.addStepListener(new Enemy3Tracker(view,world.getEnemy3()));
        world.addStepListener(new EnemyTracker(view,world.getEnemy()));
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

    public void goNextLevel(){
        world.stop();
        gamebgm.stop();
        int ring = getSonic().getRingCount();
        int health = getSonic().getHealth();
        if (level == 3){
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
            world.populate(this);
            getSonic().setRingCount(ring);
            getSonic().setHealth(health);
            controller.setBody(world.getSonic());
            view.setWorld(world);
            world.addStepListener(new SonicTracker(view, world.getSonic()));

            world.start();
        }

    }

    /** Run the game. */
    public static void main(String[] args) {
//        new Game();
        MainMenu mainMenu = new MainMenu();

    }
}
