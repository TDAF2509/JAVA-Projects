package game;

import city.cs.engine.*;

public class Boost extends StaticBody {
    private Sonic sonic;

    public Boost(World w) {
        super(w);

        Shape boostShape = new PolygonShape(0.68f,-0.29f, -0.7f,-0.28f, -0.69f,0.2f, -0.51f,0.32f, 0.15f,0.31f, 0.34f,0.23f, 0.66f,-0.15f);
        GhostlyFixture boostFixture = new GhostlyFixture(this,boostShape);
        addImage(new BodyImage("data/ground (5).png",5));
    }
}
