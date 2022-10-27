package game;

import city.cs.engine.*;

public class Bounce extends StaticBody {
    private static final Shape springShape = new BoxShape(2,2);
    private static final BodyImage springImage = new BodyImage("data/bounce.png",25);
    public Bounce(World w) {
        super(w,springShape);
        addImage(springImage);
    }
}
