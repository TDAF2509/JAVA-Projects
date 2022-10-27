package game;

import city.cs.engine.*;
import java.awt.Color;
import java.util.List;

import javax.swing.*;

import org.jbox2d.common.Vec2;

public class Game {

    /** The World in which the bodies move and interact. */
    public GameWorld world;

    /** A graphical display of the world (a specialised JPanel). */
    private UserView view;

    private Enemy enemy;

    /** Initialise a new Game. */
    public Game() {


        // make the world
        world = new GameWorld();

        //view = new UserView(world, 500, 500);
        view = new Background(world,500,500);


        //view.setBackground(Color.black);
        System.out.println(world.getGravity());

        // make a view
        // uncomment this to draw a 1-metre grid over the view
         view.setGridResolution(1);

        // display the view in a frame
        final JFrame frame = new JFrame("Event handling");

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


        frame.addKeyListener(new Controller(world.getPlayer()));

        //Tracker tracker = new Tracker(enemy);
        view.setBounds(-208,0,3,50);

        // uncomment to make the view track the bird
         world.addStepListener(new Tracker(view, world.getPlayer()));

        // uncomment this to make a debugging view
         JFrame debugView = new DebugViewer(world, 500, 500);

        // start!
        world.start();
    }

    /** Run the game. */
    public static void main(String[] args) {
        new Game();
     
        
    }
}
