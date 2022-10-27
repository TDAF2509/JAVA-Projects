package game;

import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class GameLevel extends World{
    private Sonic sonic;
    private Enemy enemy = new Enemy(this);
    private Enemy2 enemy2 = new Enemy2(this);
    private Enemy3 enemy3 = new Enemy3(this);
    private EggMan eggMan = new EggMan(this);
    private EggManDefeated eggmanDefeated = new  EggManDefeated(this);
    private Checkpoint checkpoint;

    public Sonic getSonic(){return sonic;}
    public Enemy getEnemy() {
        return enemy;
    }
    public Enemy2 getEnemy2() {
        return enemy2;
    }
    public Enemy3 getEnemy3(){return enemy3;}
    public EggMan getEggMan() {
        return eggMan;
    }
    public EggManDefeated getEggmanDefeated() {
        return eggmanDefeated;
    }


    public void populate(Game game){
        sonic = new Sonic(this);
        sonic.setPosition(startPosition());
        checkpoint = new Checkpoint(this);
        checkpoint.setPosition(checkpointPosition());
        checkpoint.addCollisionListener(new EndListener(game));

    }

    public abstract Vec2 startPosition();
    public abstract Vec2 checkpointPosition();
    public abstract boolean isCompleted();
    public abstract int gameLevel();
}
