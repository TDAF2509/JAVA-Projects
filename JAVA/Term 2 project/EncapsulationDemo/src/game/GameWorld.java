/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 */
public class GameWorld extends World {
    public GameWorld() {
        super();

        // make the ground
        Shape groundShape = new BoxShape(11, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -11.5f));


        // make a platform
        Shape platformShape = new BoxShape(4, 0.5f);
        Body platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-9, 5.5f));
        Body platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(9, 3.5f));
        platform2.setAngleDegrees(30);


        // make a character
        Body bird = new YellowBird(this);
        bird.setPosition(new Vec2(-8, -10));


        // make the hammer     
        DynamicBody hammer = new Hammer(this);
        hammer.setPosition(new Vec2(-6, 10));
        hammer.setAngleDegrees(-10);


        // walls
        Shape wallShape = new BoxShape(0.5f, 6);
        Body leftWall = new StaticBody(this, wallShape);
        leftWall.setPosition(new Vec2(-11.5f, -6));
        Body rightWall = new StaticBody(this, wallShape);
        rightWall.setPosition(new Vec2(11.5f, -6));

        /*
        // build a tower
        Shape shape1 = new BoxShape(0.5f, 0.25f);
        for (int n = 0; n < 10; n++) {
            Body box = new DynamicBody(this, shape1);
            box.setPosition(new Vec2(-5, n*0.5f - 10.75f));
        }

        // build a pyramid
        Shape shape2 = new BoxShape(0.5f, 0.5f);
        for (int y = 0; y < 10; y++) {
            for (int x = y; x < 10; x++) {
                Body box = new DynamicBody(this, shape2);
                box.setPosition(new Vec2(x - y / 2.0f, y - 10.5f));                }
        }
        */


    }
}
