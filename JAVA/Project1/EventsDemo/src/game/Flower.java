package game;

import city.cs.engine.*;

public class Flower extends StaticBody {
    public Flower(World world) {
        super(world);

        Shape flowerShape = new PolygonShape(-0.49f,0.83f, -0.66f,-0.32f, -0.42f,-0.78f, 0.57f,-0.77f, 0.57f,-0.34f, 0.45f,0.83f);
        GhostlyFixture flowerFixture = new GhostlyFixture(this, flowerShape);
        addImage(new BodyImage("data/flower.gif", 3));
    }
}
