package game;

import city.cs.engine.*;

public class Flower2 extends StaticBody {
    public Flower2(World world) {
        super(world);

        Shape flowerShape = new PolygonShape(-0.6f,-0.46f, -0.61f,-0.26f, -0.27f,0.4f, 0.0f,0.51f, 0.4f,-0.08f, 0.59f,-0.37f, 0.59f,-0.49f);
        GhostlyFixture flowerFixture = new GhostlyFixture(this, flowerShape);
        addImage(new BodyImage("data/flower 2.png", 4));
    }
}