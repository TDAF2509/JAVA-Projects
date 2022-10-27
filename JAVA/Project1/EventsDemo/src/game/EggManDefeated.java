package game;

import city.cs.engine.*;

public class EggManDefeated extends Walker{
    private static final Shape eggShape = new CircleShape(3);

    private static final BodyImage explosion = new BodyImage("data/eggsplosion.gif",11);

    private static final BodyImage eggrun = new BodyImage("data/eggmanRun.gif",11);

    private EggMan eggMan;

    public EggManDefeated(World world) {
        super(world,eggShape);
        addImage(eggrun);
    }

    public static BodyImage getExplosion() {
        return explosion;
    }

    public static BodyImage getEggrun() {
        return eggrun;
    }
}
