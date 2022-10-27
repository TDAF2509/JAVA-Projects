package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author greg
 */

/**
 * A world with some bodies.
 */
public class GameWorld extends World {
    private Sonic sonic;
    private Enemy enemy;
    private Health health;

    public GameWorld() {
        super();

        BoxShape groundShape,wallShape;
        StaticBody ground,ground1,wallBody;
        BodyImage gr,wall;
        Tree tree;
        Rock rock;
        Flower flower;
        Flower2 flower2;
        Spike spike;


        // make the ground
        for (int i = 0; i<600;i++){
            groundShape = new BoxShape(2.0f, 1.0f);
            ground = new StaticBody(this, groundShape);
            ground.setPosition(new Vec2((float)(i * 2 -200), 0f));
            gr = new BodyImage("data/ground1.png", 2.0f);
            ground.addImage(gr);

            ground1 = new StaticBody(this,groundShape);
            ground1.setPosition(new Vec2((float)(i*28-188.5),-10.9f));
            gr = new BodyImage("data/bg3.png",20f);
            ground1.addImage(gr);

        }

        // invisible wall
//        wallShape = new BoxShape(7,20);
//        wallBody = new StaticBody(this,wallShape);
//        wallBody.setPosition(new Vec2(-209.5f,0));
//        wall = new BodyImage("data/bg3.png",20);
//        wallBody.addImage(wall);
        

        // Platforms
        Shape boxShape = new BoxShape(4, 1.8f);
        Shape slopeShape = new PolygonShape(2.12f,-1.49f, 2.14f,-0.34f, -2.17f,0.7f, -2.17f,-1.49f);
        BodyImage p1 = new BodyImage("data/platform.png",4.5f);

        Body platform1 = new StaticBody(this, boxShape);
        platform1.setPosition(new Vec2(-7, 10.5f));
        platform1.addImage(p1);

        Body platform2 = new StaticBody(this,boxShape);
        platform2.setPosition(new Vec2(2,20.5f));
        platform2.addImage(p1);

        Body platform3 = new StaticBody(this,boxShape);
        platform3.setPosition(new Vec2(14,20.5f));
        platform3.addImage(p1);

//        for (int i=0; i<50;i++){
//            Body platform6 = new StaticBody(this, slopeShape);
//            platform6.setPosition(new Vec2(-i*4.37f -12, 0.56f+i));
//            BodyImage p3 = new BodyImage("data/groundSlope.png",3);
//            platform6.addImage(p3);
//        }

        // spike
        for (int i=0; i<30; i++){
            spike = new Spike(this);
            spike.setPosition(new Vec2(i*20-140,2));
        }

        // make a character
        sonic = new Sonic(this);
        sonic.setPosition(new Vec2(-180, 10));

        // enemy
        for (int i=0;i<20;i++){
            enemy = new Enemy(this);
            enemy.setPosition(new Vec2(i*50-30,5));
            enemy.addCollisionListener(new Interactions(sonic,health));
        }



       for (int i = 0; i < 10; i++) {
//



          Body ring = new Ring(this);
            ring.setPosition(new Vec2(i*2-20, 10));
            ring.addCollisionListener(new Interactions(sonic,health));
        }

        for (int i = 0; i<3;i++){
            Body health = new Health(this);
            health.setPosition(new Vec2((float)(i*15 - 10),10));
            health.addCollisionListener(new Interactions(this.sonic,this.health));
        }


        // rocks
        for (int i=0 ; i<20;i++){
            rock = new Rock(this);
            rock.setPosition(new Vec2(i*20-155,1.25f));
        }

        // trees
        for (int i=0; i<120;i++){
            tree=new Tree(this);
            tree.setPosition(new Vec2(i*10 - 200,7f));

        }

        // flower
        for (int i = 0; i<20;i++){
            flower = new Flower(this);
            flower.setPosition(new Vec2(i*40-168,2));
        }

        // flower2

        for (int i = 0; i<20;i++){
            flower2 = new Flower2(this);
            flower2.setPosition(new Vec2(i*40-164,1.5f));
        }

    }

    public Sonic getPlayer() {
        return this.sonic;
    }
}
