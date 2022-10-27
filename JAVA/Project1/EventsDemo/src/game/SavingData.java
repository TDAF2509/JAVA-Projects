package game;

import city.cs.engine.DynamicBody;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class SavingData{
    private String fileName;
    private GameLevel gameWorld;


    public SavingData(String fileName) {
        this.fileName = fileName;
    }

    public void saveGameScore(GameLevel gameWorld) throws IOException {
        boolean append = true;
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, false);
            writer.write(gameWorld.gameLevel()+"\r\n");
            writer.write(gameWorld.getSonic().getRingCount()+","+gameWorld.getSonic().getHealth()+"\r\n");
            for (DynamicBody body : gameWorld.getDynamicBodies()){
                writer.write(body.getClass().getSimpleName()+","+body.getPosition().x+","+body.getPosition().y+"\r\n");
            }
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
