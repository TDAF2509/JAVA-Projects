package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Enemy extends Walker{
    private Enemy enemy;
    private Sonic sonic;

    public Enemy(World world){
        super(world,enemyShape);
        addImage(enemyImage);

    }

    private static final Shape enemyShape = new PolygonShape(-0.09f,1.48f, -1.93f,0.86f, -1.97f,-1.34f, 1.87f,-1.33f, 1.85f,0.36f, 0.81f,1.36f);

    private static final BodyImage enemyImage = new BodyImage("data/Enemy.gif",3);

    private static final BodyImage itemBoximageAfter = new BodyImage("data/item box after.png",4);

    public BodyImage getItemBoximageAfter() {
        return itemBoximageAfter;
    }
}
