package game;

import city.cs.engine.*;

public class PipeStart extends StaticBody {
    private static final Shape pipeShape = new PolygonShape(-0.71f,0.18f, 0.42f,0.16f, 0.67f,0.08f, 0.67f,-0.13f, -0.71f,-0.05f);
    private static final BodyImage pipeImage = new BodyImage("data/ground (6).png",10);
    public PipeStart(World w) {
        super(w,pipeShape);
        addImage(pipeImage);
    }

    public static BodyImage getPipeImage() {
        return pipeImage;
    }
}
