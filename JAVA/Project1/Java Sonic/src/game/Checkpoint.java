package game;

import city.cs.engine.*;

public class Checkpoint extends StaticBody{
    private static final Shape checkpointShape =new PolygonShape(1.02f,-1.39f, 1.01f,1.49f, -1.14f,1.5f, -1.12f,-1.4f);
    private static final BodyImage checkpoint = new BodyImage("data/EndPoint.gif",5);
    public Checkpoint(World w) {
        super(w,checkpointShape);
        addImage(checkpoint);
    }

    public static BodyImage getCheckpoint() {
        return checkpoint;
    }


}
