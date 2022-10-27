package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Level2 extends GameLevel {
    private static final int RINGNUM =10;
    private Ring ring;
    private Health health;
    private BGsets bGsets;
    private BGsets4 bGsets4;
    private BGsets5 bGsets5;
    private BGsets6 bGsets6;
    private Trees trees;
    private Flower flower;
    private Flower2 flower2;
    private PipeStart pipeStart;
    private PipeMain pipeMain;
    private Bounce bounce;
    private Enemy enemy;
    private Enemy3 enemy3;

    @Override
    public void populate(Game game){
        super.populate(game);

        BoxShape groundShape,ground1Shape;
        StaticBody ground,ground1;
        BodyImage gr;
        groundShape = new BoxShape(5.0f, 1.0f);
        ground1Shape = new BoxShape(13.1f,10);
        Shape boxShape = new BoxShape(4, 1.8f);
        BodyImage p1 = new BodyImage("data/platform.png",4f);

        // Starting Ground
        for (int i = 0; i<10;i++){
            ground = new StaticBody(this, groundShape);
            ground.setPosition(new Vec2(-196.4f + i*10.2f, 0f));
            gr = new BodyImage("data/ground1.png", 2);
            ground.addImage(gr);

            ground1 = new StaticBody(this,ground1Shape);
            ground1.setPosition(new Vec2(-189f+i*8.6f,-10.2f));
            gr = new BodyImage("data/bg3.png",18.4f);
            ground1.addImage(gr);
        }

        // Second Ground
        for (int i = 0; i<8;i++){
            ground = new StaticBody(this, groundShape);
            ground.setPosition(new Vec2(-93.4f + i*10.3f, 6f));
            gr = new BodyImage("data/ground1.png", 2);
            ground.addImage(gr);

            ground1 = new StaticBody(this,ground1Shape);
            ground1.setPosition(new Vec2(-86f+i*8.5f,-4.2f));
            gr = new BodyImage("data/bg3.png",18.4f);
            ground1.addImage(gr);
        }

        // Third Ground
        for (int i=0; i<8;i++){
            ground = new StaticBody(this, groundShape);
            ground.setPosition(new Vec2(93.4f + i*10.3f, -30f));
            gr = new BodyImage("data/ground1.png", 2);
            ground.addImage(gr);

            ground1 = new StaticBody(this,ground1Shape);
            ground1.setPosition(new Vec2(100f+i*8.5f,-39.4f));
            gr = new BodyImage("data/bg3.png",17.4f);
            ground1.addImage(gr);
        }

        // Spring
        bounce = new Bounce(this);
        bounce.setPosition(new Vec2(125.4f,-30));
        bounce.addCollisionListener(new ObjectInteraction(getSonic(),bounce,game));

        // Fourth Ground
        for (int i=0; i<8;i++){
            ground = new StaticBody(this, groundShape);
            ground.setPosition(new Vec2(135.4f + i*10.3f, 46f));
            gr = new BodyImage("data/ground1.png", 2);
            ground.addImage(gr);

            ground1 = new StaticBody(this,ground1Shape);
            ground1.setPosition(new Vec2(142f+i*8.5f,36.4f));
            gr = new BodyImage("data/bg3.png",17.4f);
            ground1.addImage(gr);
        }

        // Fifth Ground
        for (int i=0; i<8;i++){
            ground = new StaticBody(this, groundShape);
            ground.setPosition(new Vec2(235.4f + i*10.3f, 44f));
            gr = new BodyImage("data/ground1.png", 2);
            ground.addImage(gr);

            ground1 = new StaticBody(this,ground1Shape);
            ground1.setPosition(new Vec2(242f+i*8.5f,34.4f));
            gr = new BodyImage("data/bg3.png",17.4f);
            ground1.addImage(gr);
        }

        // Sixth Ground
        for (int i=0; i<20;i++){
            ground = new StaticBody(this, groundShape);
            ground.setPosition(new Vec2(385.4f + i*11.3f, 75f));
            gr = new BodyImage("data/ground1.png", 2);
            ground.addImage(gr);

            ground1 = new StaticBody(this,ground1Shape);
            ground1.setPosition(new Vec2(392f+i*10.6f,65.4f));
            gr = new BodyImage("data/bg3.png",17.4f);
            ground1.addImage(gr);
        }

        // Platforms
        for (int i=0;i<5;i++){
            Body platform1 = new StaticBody(this, boxShape);
            platform1.setPosition(new Vec2(325.9f+i*10, 45.8f+i*6));
            platform1.addImage(p1);
        }

        // Pipe
        for (int i = 0; i<60;i++){
            pipeMain=new PipeMain(this);
            pipeStart=new PipeStart(this);

            pipeStart.setPosition(new Vec2(-15,6));
            pipeMain.setPosition(new Vec2(-10.5f+i*2.6f,5.2f-i*0.9f));

            pipeStart.addCollisionListener(new ObjectInteraction(getSonic(),bounce,game));
            pipeMain.addCollisionListener(new ObjectInteraction(getSonic(),bounce,game));
        }

        //Left most wall
        for (int i=0;i<1;i++){
            Shape wallShape = new BoxShape(30,30);
            Body wall = new StaticBody(this,wallShape);
            wall.addImage(new BodyImage("data/bg3.png",43));
            wall.setPosition(new Vec2(-232.5f,5));
        }

        //Right most wall
        Shape wallShape = new BoxShape(50,35);
        Body wall = new StaticBody(this,wallShape);
        wall.addImage(new BodyImage("data/bg3.png",70));
        wall.setPosition(new Vec2(220.5f,-6));

        // Enemy
        getEnemy().setPosition(new Vec2(90,10));
        getEnemy().addCollisionListener(new Interactions(getSonic(),getEnemy(),getEnemy2(),getEnemy3(),getEggMan(),game));
        getEnemy3().setPosition(new Vec2(150,47));
        getEnemy3().addCollisionListener(new Interactions(getSonic(),getEnemy(),getEnemy2(),getEnemy3(),getEggMan(),game));

        for (int i=0;i<5;i++){
            enemy=new Enemy(this);
            enemy.setPosition(new Vec2(-120+i*70,15));
            enemy.addCollisionListener(new Interactions(getSonic(),enemy,getEnemy2(),enemy3,getEggMan(),game));
        }

        for (int i=0;i<5;i++){
            enemy3=new Enemy3(this);
            enemy3.setPosition(new Vec2(140+i*70,15+i*40));
            enemy3.addCollisionListener(new Interactions(getSonic(),enemy,getEnemy2(),enemy3,getEggMan(),game));
        }
//        getEggMan().setPosition(new Vec2(-80,90));


        // rings
        for (int i = 0; i < 30; i++) {
            ring = new Ring(this);
            ring.setPosition(new Vec2(i*2-180, 10));
            ring.addCollisionListener(new ObjectInteraction(getSonic(),bounce,game));
        }
        //health
        for (int i = 0; i<1;i++){
            health = new Health(this);
            health.setPosition(new Vec2(-200,5));
            health.addCollisionListener(new ObjectInteraction(getSonic(),bounce,game));
        }

        //health
        health = new Health(this);
        health.setPosition(new Vec2(182,-25));
        health.addCollisionListener(new ObjectInteraction(getSonic(),bounce,game));

        //Trees
        for (int i=0; i<5; i++){
            trees = new Trees(this);
            trees.setPosition(new Vec2(-88 + i*15,10));
        }

        //Trees
        for (int i=0; i<14; i++){
            trees = new Trees(this);
            trees.setPosition(new Vec2(400 + i*15,80));
        }

        // BGsets
        bGsets = new BGsets(this);
        bGsets5 = new BGsets5(this);
        bGsets6 = new BGsets6(this);

        // flower
        flower = new Flower(this);
        flower.setPosition(new Vec2(140,-28));


        // flower2

        flower2 = new Flower2(this);
        flower2.setPosition(new Vec2(145,-28.5f));

        bGsets.setPosition(new Vec2(-170,4));
        bGsets5.setPosition(new Vec2(-160,4));
        bGsets6.setPosition(new Vec2(100,-27));

        // Waterfall
        for (int i=0;i<2;i++){
            bGsets4 = new BGsets4(this);
            bGsets4.setPosition(new Vec2(223f,37.56f-i*8.3f));
        }
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(-190, 5);
    }

    @Override
    public Vec2 checkpointPosition() {
        return new Vec2(600, 78);
    }

    @Override
    public boolean isCompleted() {
        return getSonic().getRingCount() >= RINGNUM;
    }

    @Override
    public int gameLevel() {
        return 2;
    }
}
