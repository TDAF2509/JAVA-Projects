package game;

import city.cs.engine.*;
import java.awt.*;
import java.util.List;

import javax.swing.JFrame;
import org.jbox2d.common.Vec2;


public class Game {

    private GameWorld world;


    private UserView view;

    //start the game
    public Game() {

        // make the world
        world = new GameWorld();

        view = new MyView(world, 1500, 500);

        // make a view
        //1-metre grid over the view
        //view.setGridResolution(1);

        // display the view in a frame
        final JFrame frame = new JFrame("Event handling");

        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // fixed window size
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view
        //view.addMouseListener(new MouseFocus(frame));

        frame.addKeyListener(new Controller(world.getPlayer()));
        
        //track the player
        world.addStepListener(new Tracker(view, world.getPlayer()));

        //debugging view
        //JFrame debugView = new DebugViewer(world, 500, 500);

        // start!
        world.start();
    }


    /** Run the game. */
    public static void main(String[] args) {
        new Game();


    }
}