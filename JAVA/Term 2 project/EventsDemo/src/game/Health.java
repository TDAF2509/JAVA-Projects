package game;

import city.cs.engine.*;

public class Health extends DynamicBody{
    private static final Shape itemBoxshape = new PolygonShape(-0.49f,1.19f, -1.02f,0.29f, -1.01f,-0.21f, -0.48f,-1.07f, 0.46f,-1.07f, 1.01f,-0.2f, 1.02f,0.32f, 0.47f,1.18f);

    private static final BodyImage itemBoximage = new BodyImage("data/item box.png",4);
    private static final BodyImage itemBoximageAfter = new BodyImage("data/item box after.png",4);
    //private Health health;

    public Health(World world){
        super(world,itemBoxshape);
        addImage(itemBoximage);
    }

    public static BodyImage getItemBoximage() {
        return itemBoximage;
    }

    public static BodyImage getItemBoximageAfter() {
        return itemBoximageAfter;
    }

//    public Health getHealth() {
//        return health;
//    }
}
