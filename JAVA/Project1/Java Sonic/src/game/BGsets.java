package game;

import city.cs.engine.*;

public class BGsets extends StaticBody {
    public BGsets(World w) {
        super(w);

        Shape bgShape = new PolygonShape(-1.49f,-0.61f, -0.82f,0.1f, 0.81f,0.61f, 1.24f,0.2f, 1.49f,-0.61f);
        GhostlyFixture bgFixture = new GhostlyFixture(this, bgShape);
        addImage(new BodyImage("data/ground (4).png", 15));
    }
}
