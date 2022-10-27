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
    private static final Shape ringShape = new CircleShape(1);
    private static final BodyImage ringImage= new BodyImage("data/ring sprite.png",1.8f);

    public Ring(World world) {
        super(world, ringShape);
        addImage(ringImage);


    }
}
