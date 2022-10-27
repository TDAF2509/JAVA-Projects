package game;

import city.cs.engine.*;

public class Ground extends StaticBody{
    public Ground(World w) {
        super(w);

        Shape slopeShape = new PolygonShape(2.16f,0.72f, -2.15f,-0.35f, -2.16f,-1.48f, 2.17f,-1.49f);
        BodyImage slopeImage = new BodyImage("data/groundSlope2.png",3);
    }
}
