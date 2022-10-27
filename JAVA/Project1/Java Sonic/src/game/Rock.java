package game;

import city.cs.engine.*;

public class Rock extends StaticBody {
    public Rock(World world) {
        super(world);

        Shape rockShape = new PolygonShape(-0.31f,0.2f, -0.68f,-0.16f, 0.68f,-0.16f, 0.31f,0.2f);
        GhostlyFixture rockFixture = new GhostlyFixture(this, rockShape);
        addImage(new BodyImage("data/rock.png", 8));
    }
}


