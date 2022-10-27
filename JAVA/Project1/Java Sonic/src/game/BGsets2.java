package game;

import city.cs.engine.*;

public class BGsets2 extends StaticBody {
    public BGsets2(World w) {
        super(w);

        Shape bgShape = new PolygonShape(-0.7f,0.26f, 0.69f,0.25f, 0.68f,-0.24f, -0.69f,-0.23f);
        GhostlyFixture bgFixture = new GhostlyFixture(this, bgShape);
        addImage(new BodyImage("data/ground (1).png", 92));
    }
}
