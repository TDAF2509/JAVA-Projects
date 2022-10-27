package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Enemy extends Walker{
    private static final Shape enemyShape = new PolygonShape(-0.20f,1.59f, -2.04f,0.97f, -2.08f,-1.45f, 1.98f,-1.44f, 1.96f,0.47f, 0.92f,1.37f);
    private static final BodyImage enemyImage = new BodyImage("data/Enemy.gif",3.1f);

    public Enemy(World world){
        super(world,enemyShape);
        addImage(enemyImage);

    }

    public static BodyImage getEnemyImage() {
        return enemyImage;
    }
}
