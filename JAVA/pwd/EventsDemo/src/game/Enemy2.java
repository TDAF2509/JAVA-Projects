package game;

import city.cs.engine.*;

public class Enemy2 extends Walker implements SensorListener {

    public Enemy2(World world) {
        super(world);
        Shape enemyShape = new PolygonShape(-1.01f,1.31f, -1.3f,-0.51f, -1.01f,-1.39f, 0.83f,-1.35f, 1.25f,-0.37f, 0.42f,1.31f);
        GhostlyFixture enemy2Fixture = new GhostlyFixture(this,enemyShape);
//        SolidFixture enemy2SFixture = new SolidFixture(this,enemyShape);
        BodyImage enemyImage = new BodyImage("data/fish.gif",3);
        addImage(enemyImage);
    }

    @Override
    public void beginContact(SensorEvent sensorEvent) {

    }

    @Override
    public void endContact(SensorEvent sensorEvent) {

    }
}
