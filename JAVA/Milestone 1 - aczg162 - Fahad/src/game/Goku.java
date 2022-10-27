package game;

import city.cs.engine.*;

/**
 * Simple character
 */
public class Goku extends Walker {
    public Goku(World world) {
        super(world, shape);
        addImage(image);
        energyCount = 0;

    }

    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance. 
    // That means there is a single shape and image for all instances of the class.
    private static final Shape shape = new PolygonShape(
            0.33f,1.81f, 1.35f,0.88f, 1.2f,-0.57f, 0.89f,-1.97f, -0.92f,-1.97f, -1.1f,-0.35f, -1.08f,0.41f, -0.83f,0.85f
    );

    //static image
    private static final BodyImage image = new BodyImage("data/goku.png", 5);

    //gif image for when the player is moving
    private static final BodyImage image1 = new BodyImage("data/goku.gif", 5);

    //coins
    private int energyCount;

    public void incrementEnergyCount() {
        energyCount++;
        System.out.println("Power! Energy count = " + energyCount);
    }

    //health count
    private int healthCount;

    public void incrementHealthCount(){
        healthCount++;
        System.out.println("Health count = " + healthCount);
    }

    public void reduceHealthCount(){
        healthCount--;
        System.out.println("Health count = " + healthCount);
    }

    public int getHealthCount() { return  healthCount; }

    public int getEnergyCountCount() {
        return energyCount;
    }

    //getter for the static image
    public BodyImage getBodyImage() {
        return image;
    }

    //getter for the moving image
    public BodyImage getBodyImage1() { return image1; }

}