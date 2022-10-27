package game;

import city.cs.engine.*;

public class Ground extends StaticBody{
    private static final Shape groundShape = new BoxShape(185, 0.5f);
    private  static final BodyImage groundImage = new BodyImage("data/ground1.png");

    public Ground(World world){
        super(world,groundShape);
        this.addImage(groundImage);

    }

}
