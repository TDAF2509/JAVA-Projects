package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;


public class GameWorld extends World {

    private Goku sayan;
    private Enemy enemy;


    public GameWorld() {
        super();
        
        // grass-rocky ground - made a loop of boxes so that i could have multiple ground images next to each other
        for (int i = 0; i < 16; i++) {
            Shape groundShape = new BoxShape(1, 0.7f);
            Body rocks1 = new StaticBody(this, groundShape);
            rocks1.setPosition(new Vec2(i*10+5, -11.5f));
            BodyImage gr = new BodyImage("data/rocks1.png", 4);
            rocks1.addImage(gr);
        }

        //rocky ground
        for (int i = 0; i < 20; i++) {
            Shape groundShape = new BoxShape(2, 1);
            Body rocks2 = new StaticBody(this, groundShape);
            rocks2.setPosition(new Vec2(i*2+7, -11.9f));
            BodyImage gr = new BodyImage("data/rocks2.png", 4);
            rocks2.addImage(gr);
        }

        //grass ground
        for (int i = 0; i < 200; i++) {
            Shape groundShape = new BoxShape(2, 1.2f);
            Body ground = new StaticBody(this, groundShape);
            ground.setPosition(new Vec2(i*4-40, -12));
            BodyImage gr = new BodyImage("data/grass.png", 4);
            ground.addImage(gr);
        }

        // make platforms

        Shape boxShape1 = new BoxShape(3, 1.8f);
        Body platform1 = new StaticBody(this, boxShape1);
        platform1.setPosition(new Vec2(-18, -5));
        BodyImage p1 = new BodyImage("data/platform1.png",7);
        platform1.addImage(p1);

        Shape boxShape2 = new BoxShape(4, 2.5f);
        Body platform2 = new StaticBody(this, boxShape2);
        platform2.setPosition(new Vec2(0, 0));
        BodyImage p2 = new BodyImage("data/platform2.png",7);
        platform2.addImage(p2);

        Shape boxShape3 = new BoxShape(4.5f, 2.9f);
        Body platform3 = new StaticBody(this, boxShape3);
        platform3.setPosition(new Vec2(28, 4));
        BodyImage p3 = new BodyImage("data/platform3.png",7);
        platform3.addImage(p3);


        // make a character
        sayan = new Goku(this);
        sayan.setPosition(new Vec2(-30, -5));

        // enemy
        enemy = new Enemy(this);
        enemy.setPosition(new Vec2(0,4));
        
        //energy balls on platform1
        for (int i = 0; i < 2; i++) {
            Body energy = new Energy(this);
            energy.setPosition(new Vec2(i*2-18, 0));
            energy.addCollisionListener(new Pickup(sayan));
        }

        //energy balls on platform3
        for (int i = 0; i < 4; i++) {
            Body energy = new Energy(this);
            energy.setPosition(new Vec2(i*2+26, 10));
            energy.addCollisionListener(new Pickup(sayan));
        }

        //health points on platform2
        for (int i = 0; i < 3; i++) {
            Body health = new Health(this);
            health.setPosition(new Vec2(i*15 - 10, 10));
            health.addCollisionListener(new Pickup(sayan));
        }

    }
    
    public Goku getPlayer() {
        return sayan;
    }

}