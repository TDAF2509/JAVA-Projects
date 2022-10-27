package game;

import city.cs.engine.*;
import city.cs.engine.Shape;

import java.awt.*;

public class Health extends DynamicBody {
    private static final Shape shape = new PolygonShape(
            -1.65f,1.29f, -1.9f,0.86f, -1.69f,0.39f, 0.31f,-1.06f, 1.21f,-0.94f, 1.56f,-0.29f, 1.09f,0.87f, 0.33f,1.03f
    );

    private static final BodyImage image =
            new BodyImage("data/senzubean.png",3);

    public Health(World world) {
        super(world, shape);
        addImage(image);
    }


}
