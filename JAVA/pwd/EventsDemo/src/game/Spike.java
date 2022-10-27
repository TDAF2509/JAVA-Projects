package game;

import city.cs.engine.*;

public class Spike extends StaticBody {
    private static final Shape spikeShape = new PolygonShape(0.66f,-0.53f, 0.5f,0.57f, -0.55f,0.56f, -0.67f,-0.53f);
    public Spike(World world) {
        super(world,spikeShape);

        SolidFixture spikeBody = new SolidFixture(this,spikeShape);
        BodyImage spikeImage = new BodyImage("data/spike.png",5);
        addImage(spikeImage);
    }
}
