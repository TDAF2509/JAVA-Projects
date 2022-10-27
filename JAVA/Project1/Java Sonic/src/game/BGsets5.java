package game;

import city.cs.engine.*;

public class BGsets5 extends StaticBody {
    public BGsets5(World w) {
        super(w);

        Shape bgShape = new PolygonShape(-0.66f,0.79f, 0.29f,0.78f, 0.67f,0.37f, 0.63f,-0.34f, 0.2f,-0.77f, -0.66f,0.11f);
        GhostlyFixture bgfixture = new GhostlyFixture(this,bgShape);
        addImage(new BodyImage("data/ground (8).png",20));
    }
}
