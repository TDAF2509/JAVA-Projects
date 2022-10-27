package game;

import city.cs.engine.*;

public class BGsets4 extends StaticBody{
    public BGsets4(World w) {
        super(w);

        Shape waterfall = new PolygonShape(4.57f,-1.48f, 4.55f,1.48f, -4.53f,1.48f, -4.57f,-1.51f);
        GhostlyFixture waterfallFixture = new GhostlyFixture(this,waterfall);
        addImage(new BodyImage("data/waterfall.gif",11.5f));

    }
}
