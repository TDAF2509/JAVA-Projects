package game;

import city.cs.engine.*;

public class Tree extends StaticBody{
    public Tree(World world){
        super(world);

        Shape barkShape = new PolygonShape(-0.1f,1.02f, -0.09f,-1.47f, 0.13f,-1.46f, 0.1f,1.03f);
        GhostlyFixture barkFixture = new GhostlyFixture(this,barkShape);
        Shape leafShape = new PolygonShape(0.29f,0.37f, 0.63f,0.7f, 0.61f,1.02f, 0.01f,1.4f, -0.63f,1.02f, -0.63f,0.7f, -0.3f,0.4f);
        GhostlyFixture leafFixture = new GhostlyFixture(this ,leafShape);
        addImage(new BodyImage("data/tree.png",20));
    }


}
