package game;

import city.cs.engine.*;

public class Wall extends StaticBody {
    private static final Shape wallShape = new BoxShape(185, 0.5f);
    private  static final BodyImage wallImage = new BodyImage("data/bg3.png",3);

    public Wall(World world){
        super(world,wallShape);
        this.addImage(wallImage);

    }

}