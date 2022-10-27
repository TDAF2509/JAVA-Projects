package game;

import city.cs.engine.*;

public class BGsets6 extends StaticBody {
    public BGsets6(World w) {
        super(w);

        Shape bgShape = new PolygonShape(-0.45f,0.26f, -0.7f,-0.01f, -0.46f,-0.24f, 0.68f,-0.24f, 0.19f,0.27f);
        GhostlyFixture bgFixture = new GhostlyFixture(this,bgShape);
        addImage(new BodyImage("data/ground (9).png",30));
    }
}
