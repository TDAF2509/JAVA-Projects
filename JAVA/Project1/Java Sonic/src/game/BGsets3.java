package game;

import city.cs.engine.*;

public class BGsets3 extends StaticBody {
    public BGsets3(World w) {
        super(w);

        Shape bgShape = new PolygonShape(7.27f,-1.39f, 7.33f,1.47f, -7.36f,1.44f, -7.36f,-1.39f);
        GhostlyFixture bgFixture = new GhostlyFixture(this, bgShape);
        addImage(new BodyImage("data/ground (2).png", 5));
    }
}
