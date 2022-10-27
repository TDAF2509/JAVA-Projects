package game;

import city.cs.engine.*;

public class Enemy3 extends Walker {
    private static final Shape crabShape = new PolygonShape(-1.9f,1.44f, -1.83f,-1.29f, 1.65f,-1.3f, 1.91f,1.47f);
    private static final BodyImage crabImageWalk = new BodyImage("data/crab walk.gif",3);
    private static final BodyImage crabImageStand = new BodyImage("data/crab stand.gif",3);
    public Enemy3(World world) {
        super(world,crabShape);
        addImage(crabImageWalk);
    }

    public static BodyImage getCrabImageWalk() {
        return crabImageWalk;
    }

    public static BodyImage getCrabImageStand() {
        return crabImageStand;
    }
}
