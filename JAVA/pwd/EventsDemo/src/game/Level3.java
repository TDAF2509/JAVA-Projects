package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Level3 extends GameLevel {
    private static final int HIT = 20;

    @Override
    public void populate(Game game) {
        super.populate(game);

        BoxShape groundShape,ground1Shape;
        StaticBody ground,ground1;
        BodyImage gr;
        groundShape = new BoxShape(5.0f, 1.0f);
        ground1Shape = new BoxShape(13.1f,10);
        Shape boxShape = new BoxShape(4, 1.8f);
        BodyImage p1 = new BodyImage("data/platform.png",4f);

        // Ground
        for (int i=0;i<80;i++){
            ground = new StaticBody(this,groundShape);
            ground.setPosition(new Vec2(i*10-20.3f,-10));
            gr = new BodyImage("data/ground1.png",2f);
            ground.addImage(gr);

            ground1 = new StaticBody(this,ground1Shape);
            ground1.setPosition(new Vec2(i*8.5f-20.01f,-20.2f));
            gr = new BodyImage("data/bg3.png",18.4f);
            ground1.addImage(gr);
        }

        //Left most wall
        for (int i = 0;i<2;i++){
            Shape wallShape = new BoxShape(30,30);
            Body wall = new StaticBody(this,wallShape);
            wall.addImage(new BodyImage("data/bg3.png",43));
            wall.setPosition(new Vec2(-48.5f+i*97f,5));
        }


        getEnemy().setPosition(new Vec2(-2220,314232));
        getEnemy2().setPosition(new Vec2(-2220,314232));
        getEnemy3().setPosition(new Vec2(-2220,314232));
        getEggMan().setPosition(new Vec2(-20,10));
        getEggmanDefeated().setPosition(new Vec2(-90,0));
        getEggMan().addCollisionListener(new Interactions(getSonic(),getEnemy(),getEnemy2(),getEnemy3(),getEggMan()));


    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(-10,-10);
    }

    @Override
    public Vec2 checkpointPosition() {
        return new Vec2(-500,0);
    }

    @Override
    public boolean isCompleted() {
        return getEggMan().getHit() >= HIT;
    }
}
