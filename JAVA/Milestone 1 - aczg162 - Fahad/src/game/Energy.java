package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


public class Energy extends DynamicBody {

    private static final Shape shape = new PolygonShape(
            -0.18f,-0.65f, 0.38f,-0.69f, 0.77f,-0.37f, 0.86f,0.14f, 0.57f,0.63f, -0.06f,0.71f, -0.52f,0.36f, -0.54f,-0.27f
    );

    private static final BodyImage image =
            new BodyImage("data/energy.gif",3);
    
    public Energy(World world) {
        super(world, shape);
        addImage(image);
    }
}