package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class EndListener implements CollisionListener{
    private Game game;

    public EndListener(Game game) {
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        Sonic sonic = game.getSonic();
        if (e.getOtherBody() == sonic && game.isCurrentLevelCompleted()){
            System.out.println("NEXT LEVEL");
            game.goNextLevel();
        }
    }
}
