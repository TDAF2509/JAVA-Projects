package game;

import city.cs.engine.*;

public class EggMan extends Walker{
    private static final Shape eggShape = new PolygonShape(1.61f,1.12f, -3.95f,1.08f, -2.55f,2.96f, -0.47f,2.84f, 0.33f,2.48f);
    private final Fixture eggFixture = new SolidFixture(this,eggShape,10);

    private static final Shape drillShape = new PolygonShape(-4.75f,0.96f, 1.69f,1.12f, 4.61f,-0.88f, 2.49f,-3.0f, -4.75f,-3.0f);
    private final Fixture drillFixture = new SolidFixture(this,drillShape,10);

    private int hit;

    private static final BodyImage eggDrillHit = new BodyImage("data/EggDrillHit.gif",22);

    private static final BodyImage eggDrill = new BodyImage("data/EggDrill.gif",22);

    public EggMan(World world) {
        super(world,eggShape);
        addImage(eggDrill);
        this.hit=0;
    }

    public void incrementHit() {
        this.hit++;
        System.out.println("HIT");
    }

    public int getHit() {
        return hit;
    }

    public static BodyImage getEggDrill() {
        return eggDrill;
    }

    public static BodyImage getEggDrillHit() {
        return eggDrillHit;
    }

    public Fixture getEggFixture() {
        return eggFixture;
    }

    public Fixture getDrillFixture() {
        return drillFixture;
    }
}
