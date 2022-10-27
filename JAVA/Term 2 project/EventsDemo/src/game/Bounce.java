package game;

import city.cs.engine.*;

public class Bounce extends StaticBody{
    private static final Shape springShape1 = new PolygonShape(-0.86f,0.62f, -1.37f,0.1f, -0.98f,-0.32f, 0.96f,-0.34f, 1.33f,0.11f, 0.84f,0.64f);
    private static final Shape springShape2 = new PolygonShape(-0.6f,1.13f, -0.92f,0.75f, -0.64f,0.47f, 0.64f,0.49f, 0.89f,0.77f, 0.56f,1.12f);
    private static final BodyImage springImage1 = new BodyImage("data/bounceStart.png",3);
    private static final BodyImage springImage2 = new BodyImage("data/bounceEnd.png",3);
    private StaticBody bounce;

    public Bounce(World world){
        super(world);
        this.bounce=bounce;
        addImage(springImage1);
    }

    public BodyImage getspringImage1(){return springImage1;}

    public BodyImage getSpringImage2() {
        return springImage2;
    }

    public StaticBody getBounce() {
        return bounce;
    }
}
