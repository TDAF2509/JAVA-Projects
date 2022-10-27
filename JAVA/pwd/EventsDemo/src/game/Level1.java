package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Level1 extends GameLevel {
    private static final int RINGNUM = 0;
    private Enemy enemy;
    private Bounce bounce;
    private Spike spike;
    private Health health;
    private Ring ring;
    private Rock rock;
    private BGsets bGsets;
    private BGsets2 bGsets2;
    private BGsets3 bGsets3;
    private BGsets4 bGsets4;
    private Boost boost;
    private Spring spring;
    private Trees trees;
    private Flower flower;
    private Flower2 flower2;

    @Override
    public void populate(Game game){
        super.populate(game);

        BoxShape groundShape,ground1Shape;
        StaticBody ground,ground1,ground2,ground3;
        BodyImage gr;
        groundShape = new BoxShape(5.0f, 1.0f);
        ground1Shape = new BoxShape(13.1f,10);
        Shape boxShape = new BoxShape(4, 1.8f);
        Shape slopeShape = new PolygonShape(2.16f,0.72f, -2.15f,-0.35f, -2.16f,-1.48f, 2.17f,-1.49f);
        BodyImage p1 = new BodyImage("data/platform.png",4f);

        // Starting Ground
        for (int i = 0; i<4;i++){
            ground = new StaticBody(this, groundShape);
            ground.setPosition(new Vec2(-196.4f + i*5, 0f));
            gr = new BodyImage("data/ground1.png", 2);
            ground.addImage(gr);

            ground1 = new StaticBody(this,ground1Shape);
            ground1.setPosition(new Vec2(-189f,-10.2f-i*18.2f));
            gr = new BodyImage("data/bg3.png",18.4f);
            ground1.addImage(gr);
        }

        // Middle Ground
        for (int i = 0; i<4;i++){
            ground = new StaticBody(this, groundShape);
            ground.setPosition(new Vec2(-16f + i*5, -10f));
            gr = new BodyImage("data/ground1.png", 2);
            ground.addImage(gr);

            ground1 = new StaticBody(this,ground1Shape);
            ground1.setPosition(new Vec2(-8.5f,-20.2f-i*18.2f));
            gr = new BodyImage("data/bg3.png",18.4f);
            ground1.addImage(gr);
        }

        // Lower Ground
        for (int i=0;i<14;i++){
            ground2 = new StaticBody(this,groundShape);
            ground2.setPosition(new Vec2(i*10-170.3f,-40.2f));
            gr = new BodyImage("data/ground1.png",2f);
            ground2.addImage(gr);

            ground3 = new StaticBody(this,ground1Shape);
            ground3.setPosition(new Vec2(i*8.5f-163.01f,-50.2f));
            gr = new BodyImage("data/bg3.png",18.4f);
            ground3.addImage(gr);
        }

        // Ground After Slope
        for (int i=0;i<12;i++){
            ground2 = new StaticBody(this,groundShape);
            ground2.setPosition(new Vec2(i*10-150.3f,0));
            gr = new BodyImage("data/ground1.png",2f);
            ground2.addImage(gr);

            ground3 = new StaticBody(this,ground1Shape);
            ground3.setPosition(new Vec2(i*8.5f-143.01f,-10.2f));
            gr = new BodyImage("data/bg3.png",18.4f);
            ground3.addImage(gr);
        }

        // Ground After Ramp
        for (int i=0;i<12;i++){
            ground2 = new StaticBody(this,groundShape);
            ground2.setPosition(new Vec2(i*10+470.3f,10));
            gr = new BodyImage("data/ground1.png",2f);
            ground2.addImage(gr);

            ground3 = new StaticBody(this,ground1Shape);
            ground3.setPosition(new Vec2(i*8.5f+478.01f,0.2f));
            gr = new BodyImage("data/bg3.png",18.4f);
            ground3.addImage(gr);
        }

        // Lower Ground Background
        for (int i=0;i<5;i++){
            bGsets3 = new BGsets3(this);
            bGsets3.setPosition(new Vec2(i*23.63f-143.45f,-20.9f));
        }

        // Bridge
        for (int i=0;i<54;i++){
            Body platform1 = new StaticBody(this, boxShape);
            platform1.setPosition(new Vec2(8.9f+i*8.3f, -10.8f));
            platform1.addImage(p1);
        }

        //Left most wall
        Shape wallShape = new BoxShape(30,30);
        Body wall = new StaticBody(this,wallShape);
        wall.addImage(new BodyImage("data/bg3.png",43));
        wall.setPosition(new Vec2(-232.5f,5));

        // Slope
        for (int i=0; i<22;i++){
            Body platform6 = new StaticBody(this,slopeShape);
            platform6.setPosition(new Vec2(i*4.37f -110, -40.56f+i));
            BodyImage p3 = new BodyImage("data/groundSlope2.png",3);
            platform6.addImage(p3);
        }

        getEnemy().setPosition(new Vec2(80,5));
        getEnemy().addCollisionListener(new Interactions(getSonic(),getEnemy(),getEnemy2(),getEnemy3(),getEggMan()));

        for (int i=0;i<3;i++){
            enemy = new Enemy(this);
            enemy.setPosition(new Vec2(-150+i*50,-30));
            enemy.addCollisionListener(new Interactions(getSonic(),getEnemy(),getEnemy2(),getEnemy3(),getEggMan()));
        }

        for (int i=0;i<5;i++){
            enemy = new Enemy(this);
            enemy.setPosition(new Vec2(70+i*50,10));
            enemy.addCollisionListener(new Interactions(getSonic(),getEnemy(),getEnemy2(),getEnemy3(),getEggMan()));
        }

        getEnemy2().setPosition(new Vec2(10,0));
        getEnemy2().addCollisionListener(new Interactions(getSonic(),getEnemy(),getEnemy2(),getEnemy3(),getEggMan()));

        getEnemy3().setPosition(new Vec2(150,47));
        getEnemy3().addCollisionListener(new Interactions(getSonic(),getEnemy(),getEnemy2(),getEnemy3(),getEggMan()));

        getEggMan().setPosition(new Vec2(-550,10));
        getEggmanDefeated().setPosition(new Vec2(-900, 0));

        if (getSonic().getPosition().y<-45){
            getSonic().setPosition(startPosition());
        }

        // spike
        for (int i=0; i<5; i++){
            spike = new Spike(this);
            spike.setPosition(new Vec2(i*20-140,2));
            spike.addCollisionListener(new Interactions(getSonic(),getEnemy(),getEnemy2(),getEnemy3(),getEggMan()));
        }

        // rings
        for (int i = 0; i < 30; i++) {
            ring = new Ring(this);
            ring.setPosition(new Vec2(i*2-180, 10));
            ring.addCollisionListener(new ObjectInteraction(getSonic(),bounce));
        }
        //health
        for (int i = 0; i<3;i++){
            health = new Health(this);
            health.setPosition(new Vec2((float)(i*15 - 10),10));
            health.addCollisionListener(new ObjectInteraction(getSonic(),bounce));
        }

        //spring
        spring =new Spring(this);
        spring.setPosition(new Vec2(454,-10f));
        spring.addCollisionListener(new ObjectInteraction(getSonic(),bounce));

        //boost
        boost = new Boost(this);
        boost.setPosition(new Vec2(12,-8.5f));

        // rocks
        for (int i=0 ; i<5;i++){
            rock = new Rock(this);
            rock.setPosition(new Vec2(i*20-150,1.25f));
        }

        // trees
        for (int i=0; i<3;i++){
            trees = new Trees(this);
            trees.setPosition(new Vec2(i*40-148,8f));
        }

        // flower
        for (int i = 0; i<4;i++){
            flower = new Flower(this);
            flower.setPosition(new Vec2(i*35-154,2));
        }

        // flower2

        for (int i = 0; i<4;i++){
            flower2 = new Flower2(this);
            flower2.setPosition(new Vec2(i*35-148,1.5f));
        }

        // bg at start
        bGsets = new BGsets(this);
        bGsets.setPosition(new Vec2(-185,4));

        // bg on lower level
        for (int j=0;j<2;j++){
            for (int i=0;i<10;i++){
                bGsets2 = new BGsets2(this);
                bGsets2.setPosition(new Vec2(i*8.5f-134.6f,-j*15-29.2f));
            }
        }
        // Waterfall
        for (int i=0;i<52;i++){
            bGsets4 = new BGsets4(this);
            bGsets4.setPosition(new Vec2(12f+i*8.3f,-15.56f));
        }
    }
    @Override
    public Vec2 startPosition() {
        return new Vec2(-190, 5);
    }

    @Override
    public Vec2 checkpointPosition() {
        return new Vec2(580, 13);
    }

    @Override
    public boolean isCompleted() {
        return getSonic().getRingCount() >= RINGNUM;
    }
}
