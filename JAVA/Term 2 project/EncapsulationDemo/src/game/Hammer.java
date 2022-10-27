
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 */
public class Hammer extends DynamicBody {
     
    public Hammer(World w) {
        super(w);
         
        Shape headShape = new PolygonShape(-0.85f,2.48f, 0.84f,2.5f, 0.83f,1.84f, -0.85f,1.87f);
        SolidFixture headFixture = new SolidFixture(this, headShape, 20);
        Shape handleShape = new PolygonShape(0.26f,1.83f, 0.22f,-2.5f, -0.26f,-2.47f, -0.22f,1.87f);
        SolidFixture handleFixture = new SolidFixture(this, handleShape, 1);
        addImage(new BodyImage("data/hammer.png", 5.0f));
    }
}
