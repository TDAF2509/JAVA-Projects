package game;

import city.cs.engine.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Simple character
 */
public class Sonic extends Walker {
    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance. 
    // That means there is a single shape and image for all instances of the class.
    private static  Shape sonicShape = new PolygonShape(0.2f,0.77f, 1.16f,0.38f, 1.03f,-1.41f, -1.17f,-1.42f, -1.07f,-0.07f, -0.01f,0.7f);
    private static final  BodyImage sonicImageRun= new BodyImage("data/sonic running right.gif",3);
    private static final BodyImage sonicImageStatic = new BodyImage("data/sonic sprite.png",3);
    private static final BodyImage sonicImageSpin = new BodyImage("data/Sonic spin.gif",3);
    private static final BodyImage sonicImageHit = new BodyImage("data/sonic hit.png",2.9f);
    private static final BodyImage sonicImageDownSpin = new BodyImage("data/sonic down spin.gif",3);
    private static final BodyImage SonicImageGameOver = new BodyImage("data/game over sonic.gif",3);
    private int ringCount;
    private int health;

    public Sonic(World world){
        super(world, sonicShape);
       this.addImage(sonicImageStatic);
        this.ringCount = 0;
        this.health = 3;
    }

    public void incrementRingCount() {
        this.ringCount++;
        System.out.println("Ring count = " + this.ringCount);
    }

    public void incrementHealth(){
        this.health++;
        System.out.println("Health = "+this.health);
    }

    public void reduceRingCount(){
        this.ringCount--;
        System.out.println("Ring Count = "+this.ringCount);
    }

    public void reduceHealth(){
        this.health--;
        System.out.println("Health = "+this.health);
    }

    public int getRingCount() {
        return ringCount;
    }

    public int getHealth(){return health;}

    public BodyImage getSonicImageStatic(){return sonicImageStatic;}

    public BodyImage getSonicImageRun(){return sonicImageRun;}

    public static BodyImage getSonicImageSpin() {return sonicImageSpin;}

    public static BodyImage getSonicImageGameOver(){return SonicImageGameOver;}

    public static BodyImage getSonicImageHit() {
        return sonicImageHit;
    }

    public static BodyImage getSonicImageDownSpin(){return sonicImageDownSpin;}
}
