package game;

import city.cs.engine.*;

public class PipeMain extends StaticBody {
    private static final Shape pipeShape = new PolygonShape(0.62f,-0.07f, -0.65f,0.34f, -0.65f,0.13f, 0.63f,-0.29f);
    private static final BodyImage pipeImage = new BodyImage("data/ground (7).png",10);
    public PipeMain(World w) {
        super(w,pipeShape);
        addImage(pipeImage);
    }

    public static BodyImage getPipeImage() {
        return pipeImage;
    }
}
