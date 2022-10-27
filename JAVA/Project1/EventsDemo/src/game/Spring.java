package game;

import city.cs.engine.*;

public class Spring extends StaticBody {
    private static final Shape springShape = new PolygonShape(-1.5f,-0.2f, -0.82f,1.37f, 0.22f,1.4f, 1.5f,0.1f, 1.49f,-0.78f, -0.12f,-1.38f, -1.52f,-1.36f);
    private static final BodyImage springImage = new BodyImage("data/spring.png",3);
    public Spring(World w) {
        super(w,springShape);
        addImage(springImage);
    }
}
