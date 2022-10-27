package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.Color;

/**
 *
 * @author greg
 */


/**
 * An orange.
 */
public class Ring extends DynamicBody {
   // private static final Shape ringShape = new PolygonShape(-0.1f,1.49f, -1.49f,-0.15f, 0.03f,-1.47f, 1.5f,0.08f );
    private static final Shape ringShape = new CircleShape(1);
    private static final BodyImage ringImage= new BodyImage("data/ring sprite.png",1.8f);

    public Ring(World world) {
        super(world, ringShape);
        addImage(ringImage);


    }
}
