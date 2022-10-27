package game;

import city.cs.engine.*;


public class Enemy extends DynamicBody{


    public Enemy(World world) {
        super(world, shape);
        addImage(image);
    }

    private static final Shape shape = new PolygonShape(
            0.24f,1.65f, 0.94f,1.49f, 1.4f,1.04f, 1.72f,0.06f, 1.62f,-0.84f, 1.5f,-1.42f, -1.58f,-1.65f, -1.62f,0.29f
    );

    private static final BodyImage image = new BodyImage("data/idle.gif", 4);


}
